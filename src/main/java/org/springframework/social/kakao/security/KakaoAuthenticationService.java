package org.springframework.social.kakao.security;

import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.connect.KakaoConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class KakaoAuthenticationService extends OAuth2AuthenticationService<Kakao> {
	public KakaoAuthenticationService(String clientId) {
		super(new KakaoConnectionFactory(clientId));
	}
}
