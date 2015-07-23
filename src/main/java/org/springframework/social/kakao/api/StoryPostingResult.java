package org.springframework.social.kakao.api;

import java.io.Serializable;

public class StoryPostingResult extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id = "";

	/**
	 * <pre>
	 * 포스팅 된 글의 id
	 * </pre>
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	StoryPostingResult() {}
}
