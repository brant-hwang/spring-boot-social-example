package org.springframework.social.kakao.api.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.Arrays;

public class AbstractKakaoOperations {
	private final boolean isAuthorized;
	
	private final static String API_HOST = "https://kapi.kakao.com";
	
	private final static MultiValueMap<String, String> EMPTY_PARAMETER = new LinkedMultiValueMap<String, String>();
	
	public AbstractKakaoOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("kakao");
		}
	}
	
	protected URI buildApiUri(String path) {
		return buildApiUri(path, EMPTY_PARAMETER);
	}
	protected URI buildApiUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_HOST + path).queryParams(parameters).build();
	}
	
	protected HttpHeaders getAdminKeyHeader(String adminKey) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Arrays.asList(new MediaType[]{MediaType.ALL}));
		headers.set("Authorization", "KakaoAK " + adminKey); //admin key를 header에 셋팅해야함
		
		return headers;
	}
}
