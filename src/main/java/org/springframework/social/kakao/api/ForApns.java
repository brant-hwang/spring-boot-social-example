package org.springframework.social.kakao.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForApns {
	private boolean isEmpty = true;
	@JsonIgnore
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	private int badge;
	private String sound;
	private boolean push_alert;
	private Object message;
	private Map<String, Object> custom_field = new LinkedHashMap<String, Object>();
	
	public int getBadge() {
		return badge;
	}
	public void setBadge(int badge) {
		this.isEmpty = false;
		this.badge = badge;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.isEmpty = false;
		this.sound = sound;
	}
	public boolean isPush_alert() {
		return push_alert;
	}
	public void setPush_alert(boolean push_alert) {
		this.isEmpty = false;
		this.push_alert = push_alert;
	}
	
	/**
	 * <pre>
	 * Apns의 경우 패킷 제한에 대한 대안으로 앱에 미리 메시지 format을 저장해두고 해당 format의 키와 파라메터만 전송이 가능함.
	 * 이럴경우 message는 단순 문자열이 아닌 json object로 전송됨
	 * 따라서 해당 항목은 사용자가 메시지를 설정한 방식에 따라 String 또는 LinkedHashMap<String, Object> 객체가 반환됨
	 * </pre>
	 * @return
	 */
	public Object getMessage() {
		return message;
	}
	/**
	 * <pre>
	 * 단순 문자열 메시지를 셋팅한다.
	 * 이 경우 getMessage 응답 object는 String 으로 casting이 가능합니다.
	 * </pre>
	 * @param message
	 */
	public void setMessage(String message) {
		this.isEmpty = false;
		this.message = message;
	}
	/**
	 * <pre>
	 * 포멧팅된 문자열 대응을 위한 메시지를 생성합니다.
	 * 이 경우 getMessage 응답 object는 LinkedHashMap<String, Object>로 casting이 가능합니다.
	 * 
	 * 참조 : https://developer.apple.com/library/ios/documentation/NetworkingInternet/Conceptual/RemoteNotificationsPG/Chapters/ApplePushService.html
	 * </pre>
	 * @param locKey
	 * @param locArgs
	 */
	public void setMessage(String locKey, List<String> locArgs) {
		this.isEmpty = false;
		LinkedHashMap<String, Object> tmp = new LinkedHashMap<String, Object>();
		tmp.put("loc-key", locKey);
		tmp.put("loc-args", locArgs);
		this.message = tmp;
	}
	
	public void addCustom_field(String key, Object value) {
		this.isEmpty = false;
		custom_field.put(key, value);
	}
	public Map<String, Object> getCustom_field() {
		return custom_field;
	}
	
	public ForApns(){}
	public ForApns(int badge, String sound, boolean push_alert, String message) {
		this.isEmpty = false;
		
		this.badge = badge;
		this.sound = sound;
		this.push_alert = push_alert;
		this.message = message;
	}
	public ForApns(int badge, String sound, boolean push_alert, String locKey, List<String> locArgs) {
		this.isEmpty = false;
		
		this.badge = badge;
		this.sound = sound;
		this.push_alert = push_alert;
		setMessage(locKey, locArgs);
	}
}
