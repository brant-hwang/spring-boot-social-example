package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoPages extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String beforeURL;
	
	private String afterURL;
	
	public String getBeforeURL() {
		return beforeURL;
	}
	
	public String getAfterURL() {
		return afterURL;
	}
	
	KakaoPages(){}
}
