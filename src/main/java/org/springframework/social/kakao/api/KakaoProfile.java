package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoProfile extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private KakaoProfileProperties properties;
	
	public long getId() {
		return this.id;
	}
	
	public KakaoProfileProperties getProperties() {
		return this.properties;
	}
	
	KakaoProfile(){}
}
