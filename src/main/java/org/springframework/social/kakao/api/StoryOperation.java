package org.springframework.social.kakao.api;

import java.util.List;


public interface StoryOperation {
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 사용 여부 확인
	 * </pre>
	 * @return
	 */
	KakaoStoryProfile isStoryUser();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 프로필 정보 조회
	 * </pre>
	 * @return
	 */
	KakaoStoryProfile getUserProfile();
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 글 작성
	 * </pre>
	 * @param storyNotePosting
	 * @return
	 */
	StoryPostingResult postNote(StoryNotePosting storyNotePosting);
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 이미지 업로드 (for postPhoto)
	 * </pre>
	 * @param storyPhotoUpload
	 * @return
	 */
	List<String> uploadPhoto(StoryPhotoUpload storyPhotoUpload);
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 포토 포함 글 작성
	 * </pre>
	 * @param storyPhotoPosting
	 * @return
	 */
	StoryPostingResult postPhoto(StoryPhotoPosting storyPhotoPosting);
	
	/**
	 * <pre>
	 * 외부 링크 정보 가져오기 (link 포스팅 정보에 활용)
	 * </pre>
	 * @param uri
	 * @return
	 */
	StoryLinkInfo linkInfo(String url);
	
	/**
	 * <pre>
	 * 해당 access token을 발급받은 사용자의 카카오 스토리 외부 페이지 링크 포함 글 작성
	 * </pre>
	 * @param storyLinkData
	 * @return
	 */
	StoryPostingResult postLink(StoryLinkPosting storyLinkPosting);
	
	/**
	 * <pre>
	 * 한개의 내 스토리 정보 가져오기
	 * </pre>
	 * @param id
	 * @return
	 */
	MyStory myStory(String id);
	
	/**
	 * <pre>
	 * 복수개의 내 스토리 정보 가져오기
	 * 
	 * 가장 최근에 작성된 내스토리 복수개를 요청하거나 지정한 스토리보다 이전에 작성된 내스토리 복수개를 요청할 수 있습니다. 
	 * 대략 18개 정도의 정보를 한꺼번에 받을 수 있습니다. 지정한 아이디의 내스토리는 결과에 포함되지 않습니다. (개발가이드 발췌)
	 * </pre>
	 * @param lastId null값 전송 시 가장 최근의 것부터 조회
	 * @return
	 */
	List<MyStory> myStories(String lastId);
	
	/**
	 * <pre>
	 * 내 스토리 글 삭제
	 * </pre>
	 * @param id
	 */
	void deleteMyStory(String id);
}
