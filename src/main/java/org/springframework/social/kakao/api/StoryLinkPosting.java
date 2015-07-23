package org.springframework.social.kakao.api;

public class StoryLinkPosting extends StoryNotePosting {
	private StoryLinkInfo storyLinkInfo;
	private String url;

	/**
	 * <pre>
	 * linkinfo api를 사용하여 조회한 사이트 정보
	 * </pre>
	 * @return
	 */
	public StoryLinkInfo getStoryLinkInfo() {
		return storyLinkInfo;
	}
	/**
	 * <pre>
	 * linkinfo api를 사용하여 조회한 사이트 정보
	 * 
	 * 만일 url값을 셋팅하여 posLink operation 을 호출한다면 해당 객체는 무시됨.
	 * </pre>
	 * @param storyLinkInfo
	 */
	public void setStoryLinkInfo(StoryLinkInfo storyLinkInfo) {
		this.storyLinkInfo = storyLinkInfo;
	}
	
	/**
	 * <pre>
	 * 링크하고자 하는 외부 사이트 url
	 * </pre>
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * <pre>
	 * 링크하고자 하는 외부 사이트 url
	 * 
	 * 해당 데이터가 셋팅 되어 있다면 linkinfo api를 호출하여 반환받은 값을 사용함.
	 * (storyLinkInfo 객체에 셋팅된 항목들 무시됨)
	 * </pre>
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
