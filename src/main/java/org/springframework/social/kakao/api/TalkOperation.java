package org.springframework.social.kakao.api;

public interface TalkOperation {
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오톡 프로필을 조회합니다.
	 * </pre>
	 * @return
	 */
	KakaoTalkProfile getUserProfile();
}
