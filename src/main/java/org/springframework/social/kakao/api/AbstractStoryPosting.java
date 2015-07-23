package org.springframework.social.kakao.api;

public class AbstractStoryPosting extends KakaoObject {
	private String permission = "A";
	private String enableShare = "true"; //카카오 API 레퍼런스에는 기본은 false라고 하나 공개 권한의 default값이  A(전체 공개)이므로 default값을 true 정의함. 
	private String androidExecParam = "";
	private String iosExecParam = "";
	private String androidMarketParam = "";
	private String iosMarketParam = "";
	
	/**
	 * <pre>
	 * 포스팅 할 스토리를 전체 공개할지 친구 공개할지 여부.
	 * </pre>
	 * @return
	 */
	public String getPermission() {
		return permission;
	}
	/**
	 * <pre>
	 * 포스팅 할 스토리를 전체 공개할지 친구 공개할지 여부.
	 * F : 친구에게만 공개, A : 전체 공개, M : 나만 보기
	 * 기본값은 A.
	 * 
	 * 전체 공개로 설정 할 경우 자동으로 공유 가능여부가 true로 변경됨.
	 * 전체 공개 설정 후 다른 설정으로 변경 시 공유 가능에 대한 설정 확인 필요.
	 * </pre>
	 * @return
	 */
	public void setPermission(String permission) {
		this.permission = permission;
		if (this.permission.equals("A")) {
			this.enableShare = "true";
		}
	}
	
	/**
	 * <pre>
	 * 친구 공개시에 친구가 해당포스팅을 공유할 수 있는지 여부.
	 * </pre>
	 * @return true or false
	 */
	public String isEnableShare() {
		return enableShare;
	}
	/**
	 * <pre>
	 * 친구 공개시에 친구가 해당포스팅을 공유할 수 있는지 여부. 
	 * 전체 공개인 경우는 공유여부 선택불가. 무조건 공유가능. 
	 * 기본값은 false.
	 * 
	 * 현 공유 상태 정보가 A(전체 공개)로 설정되어있다면 무조건 true 설정
	 * </pre>
	 * @param enableShare
	 */
	public void setEnableShare(boolean enableShare) {
		if (this.permission.equals("A")) {
			enableShare = true;
		}
		
		if (enableShare) {
			this.enableShare = "true";
		} else {
			this.enableShare = "false";
		}
	}
	
	/**
	 * <pre>
	 * Android 앱 실행 URL에 같이 붙여줄 파라미터.
	 * </pre>
	 * @return
	 */
	public String getAndroidExecParam() {
		return androidExecParam;
	}
	/**
	 * <pre>
	 * Android 앱 실행 URL에 같이 붙여줄 파라미터.
	 * 기본 URL "kakao[appkey]://kakaostory" 뒤에 파라미터로 붙게 된다.
	 * 
	 * 기본값은 emtpty string으로 null 또는 empty 일경우 해당 정보는 api 요청 파라메터에 포함되지 않음.
	 * </pre>
	 * @return
	 */
	public void setAndroidExecParam(String androidExecParam) {
		this.androidExecParam = androidExecParam;
	}
	
	/**
	 * <pre>
	 * iOS 앱 실행 URL에 같이 붙여줄 파라미터. 
	 * </pre>
	 * @param iosExecParam
	 */
	public String getIosExecParam() {
		return iosExecParam;
	}
	/**
	 * <pre>
	 * iOS 앱 실행 URL에 같이 붙여줄 파라미터. 
	 * 기본 URL "kakao[appkey]://kakaostory" 뒤에 파라미터로 붙게 된다.
	 * 
	 * 기본값은 emtpty string으로 null 또는 empty 일경우 해당 정보는 api 요청 파라메터에 포함되지 않음.
	 * </pre>
	 * @param iosExecParam
	 */
	public void setIosExecParam(String iosExecParam) {
		this.iosExecParam = iosExecParam;
	}
	
	/**
	 * <pre>
	 * Android 앱 마켓 URL에 같이 붙여줄 파라미터.
	 * </pre>
	 * @return
	 */
	public String getAndroidMarketParam() {
		return androidMarketParam;
	}
	/**
	 * <pre>
	 * Android 앱 마켓 URL에 같이 붙여줄 파라미터.
	 * 기본 URL "market://details?id=[android package name]" 뒤에 파라미터로 붙게 된다.
	 * 
	 * 기본값은 emtpty string으로 null 또는 empty 일경우 해당 정보는 api 요청 파라메터에 포함되지 않음.
	 * </pre>
	 * @return
	 */
	public void setAndroidMarketParam(String androidMarketParam) {
		this.androidMarketParam = androidMarketParam;
	}
	
	/**
	 * <pre>
	 * iOS 앱 마켓 URL에 같이 붙여줄 파라미터.
	 * </pre>
	 * @return
	 */
	public String getIosMarketParam() {
		return iosMarketParam;
	}
	/**
	 * <pre>
	 * iOS 앱 마켓 URL에 같이 붙여줄 파라미터.
	 * 기본 URL "https://itunes.apple.com/app/id[앱스토어 ID]" 뒤에 파라미터로 붙게 된다.
	 * 
	 * 기본값은 emtpty string으로 null 또는 empty 일경우 해당 정보는 api 요청 파라메터에 포함되지 않음.
	 * </pre>
	 * @return
	 */
	public void setIosMarketParam(String iosMarketParam) {
		this.iosMarketParam = iosMarketParam;
	}
}
