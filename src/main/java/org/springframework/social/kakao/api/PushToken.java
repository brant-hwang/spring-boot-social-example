package org.springframework.social.kakao.api;

import java.io.Serializable;

public class PushToken extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String device_id;
	private String push_type;
	private String push_token;
	private String created_at;
	private String updated_at;
	
	public String getUser_id() {
		return user_id;
	}
	
	public String getDevice_id() {
		return device_id;
	}

	public String getPush_type() {
		return push_type;
	}

	public String getPush_token() {
		return push_token;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	PushToken(){}
}
