package org.springframework.social.kakao.connect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class KakaoOAuth2Template extends OAuth2Template {
	public KakaoOAuth2Template(String clientId) {
		super(clientId, ""
				, "https://kauth.kakao.com/oauth/authorize"
				, "https://kauth.kakao.com/oauth/token");
		setUseParametersForClientAuthentication(true);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Arrays.asList(new MediaType[]{MediaType.ALL}));
		HttpEntity<?> requestEntity = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
		
		LinkedHashMap<String, Object> response = getRestTemplate().postForObject(accessTokenUrl, requestEntity, LinkedHashMap.class);
		
		if (logger.isDebugEnabled()) {
			logger.debug(new StringBuilder("response : ").append(response).toString());
		}
		
		String expires = response.get("expires_in").toString();
		return new AccessGrant(response.get("access_token").toString()
				, response.get("scope").toString()
				, response.get("refresh_token").toString()
				, expires != null ? Long.valueOf(expires) : null);
	}

	private Logger logger = LoggerFactory.getLogger(KakaoOAuth2Template.class);
}
