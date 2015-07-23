package org.springframework.social.kakao.api;

public interface UserOperation {
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 고유 id값을 가져옵니다.
	 * </pre>
	 * @return
	 */
	long getProfileId();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 닉네임 정보를 가져옵니다.
	 * </pre>
	 * @return
	 */
	String getNickname();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 프로필 정보를 조회합니다.
	 * </pre>
	 * @return
	 */
	KakaoProfile getUserProfile();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 앱 연결을 해제 합니다.
	 * - 앱과의 연동이완전히 끊기며 해당 사용자 정보는 제거 되어 복구 불가능합니다.
	 * </pre> 
	 * @return
	 */
	KakaoProfile unlink();
	
	/**
	 * <pre>
	 * 해당 access token의 상태를 확인한다.
	 *  - 비정상적 토큰의 경우 401 error 발생 (org.springframework.web.client.HttpClientErrorException)
	 * </pre>
	 * @return
	 */
	AccessTokenInfo accessTokenInfo();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 프로필 정보를 수정합니다.
	 *  - 관리자 페이지에서 확인가능한 default field이외에 개발자가 추가한 custom field의 데이터에 대한 데이터를 셋팅하는데 사용합니다.
	 *  - 반환 데이터에는 업데이트된 사용자의 id 만 존재합니다. 
	 * </pre>
	 * @param profileJsonString 변경하고자 하는 계정의 정보로 json형태의 key:value 
	 * @return
	 */
	KakaoProfile updateProfile(String profileJsonString);
	
	/**
	 * <pre>
	 * 로그아웃
	 *  - 반환 데이터는 업데이트된 사용자의 id 만 존재합니다.
	 * </pre>
	 * @return
	 */
	KakaoProfile logout();
	
	/**
	 * <pre>
	 * 앱 연결
	 *  - 카카오 플랫폼 서비스에서 자동 앱 연결 기능을 제공하므로 해당 기능을 해제 하고 운영중인 경우에만 사용합니다.
	 *  - 앱 연결 기능을 호출 할때 updateProfile로 제공하는 사용자 정보 저장 기능이 동시에 지원됩니다. (정보저장을 원치 않을 경우 null 또는 empty string 값을 파라메터로 전송하면 됩니다.)
	 * </pre>
	 * @return
	 */
	KakaoProfile signup(String profileJsonString);
	
	/**
	 * <pre>
	 * 사용자 목록 가져오기
	 *  - admin key를 이용하여 해당 앱에 연결되어있는 사용자 목록을 조회합니다.
	 *    검색 관련 파라메터가 없이 조회를 진행하는것으로 (검색 관련 파라메터는 전부 optional)
	 *    order 옵션은 asc로 조회되는 목록의 수는 기본값이 100명까지 조회됩니다.
	 *    관련사항은 아래의 kakao rest api 개발가이드 페이지를 참조 하시기 바랍니다.
	 *    https://developer.kakao.com/docs/restapi#사용자-관리-사용자-리스트-요청 
	 * </pre>
	 * @return
	 */
	KakaoIds ids();
	
	/**
	 * <pre>
	 * 사용자 목록 가져오기
	 *  - admin key를 이용하여 해당 앱에 연결되어있는 사용자 목록을 조회합니다.
	 *    검색 관련 파라메터를 셋팅하여 조회 할때 사용하며 각 파라메터 정보는 
	 *    ids() 메서드의 주석에 나와있는 개발가이드 페이지를 참조 하시기 바랍니다.
	 * </pre>
	 * @param limit
	 * @param fromId
	 * @param order
	 * @return
	 */
	KakaoIds ids(String limit, String fromId, String order);
	
	/**
	 * <pre>
	 * 사용자 정보 조회하기.
	 * 해당 기능은 관리자의 admin key와 특정 유저 id (kakao 플랫폼에서 발급되는 유저 고유번호)를 이용하여 해당 사용자의 정보를 조회한다.
	 * </pre>
	 * @param userId
	 * @return
	 */
	KakaoProfile getUserProfile(String userId);
}