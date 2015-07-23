package org.springframework.social.kakao.api;

import org.springframework.social.ApiBinding;

public interface Kakao extends ApiBinding {
	/**
	 * <pre>
	 * 사용자 관리 API 호출
	 * </pre>
	 * @return
	 */
	UserOperation userOperation();
	
	/**
	 * <pre>
	 * 카카오 스토리 API 호출
	 * </pre>
	 * @return
	 */
	StoryOperation storyOperation();
	
	/**
	 * <pre>
	 * 카카오 톡 API 호출
	 * </pre>
	 * @return
	 */
	TalkOperation talkOperation();
	
	/**
	 * <pre>
	 * 푸시 알림 API 호출
	 * </pre>
	 * @return
	 */
	PushOperation pushOperation();
}
