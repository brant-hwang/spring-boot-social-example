package org.springframework.social.kakao.api;

import java.io.Serializable;

public class KakaoStoryProfile extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean isStoryUser;
	
	private String nickName;
	private String profileImageURL;
	private String thumbnailURL;
	private String bgImageURL;
	private String permalink;
	private String birthday;
	private String birthdayType;
	
	public boolean getIsStoryUser() {
		return isStoryUser;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public String getProfileImageURL() {
		return profileImageURL;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public String getBgImageURL() {
		return bgImageURL;
	}

	public String getPermalink() {
		return permalink;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getBirthdayType() {
		return birthdayType;
	}
	
	KakaoStoryProfile(){}
}
