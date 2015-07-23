package org.springframework.social.kakao.api;

import java.io.Serializable;

public class AccessTokenInfo extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long expiresInMillis;
	
	public long getExpiresInMillis() {
		return this.expiresInMillis;
	}
	
	AccessTokenInfo() {}
}
