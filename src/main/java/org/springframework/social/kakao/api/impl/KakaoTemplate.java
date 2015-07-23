package org.springframework.social.kakao.api.impl;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.kakao.api.*;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.HttpRequestDecorator;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

public class KakaoTemplate extends AbstractOAuth2ApiBinding implements Kakao {
	private UserOperation userOperation;
	private StoryOperation storyOperation;
	private TalkOperation talkOperation;
	private PushOperation pushOperation;

	private String adminKey;
	private RestTemplate adminRestTemplate;

	public KakaoTemplate() {
		initialize();
	}

	@Deprecated
	public KakaoTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	public KakaoTemplate(String accessToken, String adminKey) {
		super(accessToken);
		this.adminKey = adminKey;
		initialize();
	}

	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	public UserOperation userOperation() {
		return userOperation;
	}

	public StoryOperation storyOperation() {
		return storyOperation;
	}

	public TalkOperation talkOperation() {
		return talkOperation;
	}

	public PushOperation pushOperation() {
		return pushOperation;
	}

	private void initialize() {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		
		//create admin rest template
		adminRestTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
		adminRestTemplate.setInterceptors(Arrays.asList(new ClientHttpRequestInterceptor[]{new AdminKeyHeaderOAuth2RequestInterceptor(adminKey)}));
		
		initSubApis();
	}

	private void initSubApis() {
		userOperation = new UserTemplate(getRestTemplate(), adminRestTemplate, isAuthorized());
		storyOperation = new StoryTemplate(getRestTemplate(), isAuthorized());
		talkOperation = new TalkTemplate(getRestTemplate(), isAuthorized());
		pushOperation = new PushTemplate(adminRestTemplate, isAuthorized());
	}

	/**
	 * admin key 사용하는 api호출 시 사용할 rest template 에 설정할 interceptor
	 */
	class AdminKeyHeaderOAuth2RequestInterceptor implements ClientHttpRequestInterceptor {
		private final String adminKey;
		
		public AdminKeyHeaderOAuth2RequestInterceptor(String adminKey) {
			this.adminKey = adminKey;
		}
		
		public ClientHttpResponse intercept(final HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
			HttpRequest protectedResourceRequest = new HttpRequestDecorator(request);
			protectedResourceRequest.getHeaders().set("Authorization", "KakaoAK " + adminKey);
			return execution.execute(protectedResourceRequest, body);
		}
	}
}
