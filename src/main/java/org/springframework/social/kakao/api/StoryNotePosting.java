package org.springframework.social.kakao.api;

public class StoryNotePosting extends AbstractStoryPosting {
	private String content = "";

	/**
	 * <pre>
	 * 포스팅에 들어갈 내용. 
	 * 길이제한은 2048자. 
	 * 사용자가 작성한 내용일 수도 있고, 앱에서 넣어주는 내용일 수도 있다.
	 * </pre>
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <pre>
	 * 포스팅에 들어갈 내용. 
	 * 길이제한은 2048자. 
	 * 사용자가 작성한 내용일 수도 있고, 앱에서 넣어주는 내용일 수도 있다.
	 * 
	 * 2048자를 넘어서는 내용은 버려지고 나머지 데이터만 전송됨.
	 * </pre>
	 * @return boolean 2048자를 넘는 값을 셋팅 할 경우 false 리턴됨.
	 */
	public boolean setContent(String content) {
		boolean returnValue = true;
		
		if (content.length() > 2048) {
			this.content = content.substring(0, 2048);
			returnValue = false;
		} else {
			this.content = content;
		}
		
		return returnValue;
	}
}
