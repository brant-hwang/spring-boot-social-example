package org.springframework.social.kakao.api;

import java.util.List;

public interface PushOperation {
	/**
	 * <pre>
	 * 푸시 토큰을 등록합니다.
	 * </pre>
	 * @param uuid 1 ~ 2^63-1 범위의 정수 형태의 값
	 * @param deviceId 기기 고유 id (멀티 디바이스 지원용)
	 * @param pushType apns 또는 gcm
	 * @param pushToken APNS, GCM으로 발급받은 push token
	 * @return 응답내용은 해당 일 이내에 재등록이 없을 경우 만료됨을 의미합니다.
	 */
	String register(String uuid, String deviceId, String pushType, String pushToken);
	
	/**
	 * <pre>
	 * 푸시 토큰을 조회합니다.
	 * </pre>
	 * @param uuid 1 ~ 2^63-1 범위의 정수 형태의 값
	 * @return
	 */
	List<PushToken> tokens(String uuid);
	
	/**
	 * <pre>
	 * 푸시 토큰을 삭제합니다.
	 * </pre>
	 * @param uuid 1 ~ 2^63-1 범위의 정수 형태의 값
	 * @param deviceId 기기 고유 id
	 * @param pushType apns 또는 gcm
	 */
	void deregister(String uuid, String deviceId, String pushType);
	
	/**
	 * <pre>
	 * 푸시 메시지를 전송합니다.
	 * 
	 * 설정의 푸시 알림과 관련하여 forApns, forGcm 파라메터 주의사항.
	 * 1. 푸시 사용을 on 하고  GCM Key, APNS 인증서 관련하여 등록하지 않은 항목에 대해서는 null 을 전달합니다.
	 *    - ex) GCM key 만 등록하였다면 send(uuids, forApns, null); 처럼 호출합니다.
	 * 2. GCM Key 및 APNS 인증서가 전부 등록되어있으나 어느 한쪽의 플랫폼 만으로 메시지를 전송 할 경우 
	 *    전송 대상이 아닌 플랫폼과 관련된 파라메터는 기본 생성자로 객체를 생성하여 전달합니다.
	 *    - ex) GCM 으로만 전송하고자 한다면 send(uuids, forApns, new ForGcm()); 처럼 호출합니다.
	 *    
	 * 푸시 사용이 on인 상황에서 GCM key 또는 APNS 인증서가 등록되어 있지 않다면 for_xxx에 대하여 전송 필요가 없으나 
	 * 둘다 등록 되어 있을경우 전송 대상 플랫폼이 아니어도 최소 {} 를 전송해야한다는 규칙을 지원하기위함 입니다.
	 * 참조 - https://developer.kakao.com/docs/restapi#푸시-알림-푸시-알림-보내기
	 * </pre>
	 * @param uuids List내의 uuid 값은 1  2^63-1 범위의 정수 형태의 값
	 * @param forApns 
	 * @param forGcm
	 */
	void send(List<String> uuids, ForApns forApns, ForGcm forGcm);
}
