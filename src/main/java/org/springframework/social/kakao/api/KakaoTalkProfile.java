package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoTalkProfile extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nickName;
	private String profileImageURL;
	private String thumbnailURL;
	private String countryISO;
	
	public String getNickName() {
		return nickName;
	}

	public String getProfileImageURL() {
		return profileImageURL;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public String getCountryISO() {
		return countryISO;
	}
	
	KakaoTalkProfile(){}
}
