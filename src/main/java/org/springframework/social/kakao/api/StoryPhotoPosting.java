package org.springframework.social.kakao.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class StoryPhotoPosting extends StoryNotePosting {
	private StoryPhotoUpload storyPhotoUpload;
	private List<String> imageUrlList;

	/**
	 * <pre>
	 * 등록대상 이미지 목록 (local device상의 이미지 목록)을 가져온다
	 * </pre>
	 * @return
	 */
	public StoryPhotoUpload getStoryPhotoUpload() {
		if (this.storyPhotoUpload != null && this.storyPhotoUpload.getFilePathList() == null) {
				return null;
		}
		return storyPhotoUpload;
	}
	/**
	 * <pre>
	 * 등록하고자 하는 이미지 정보를 셋팅한다.
	 * 해당 데이터가 존재 한다면 2단계의 프로세스를 진행하게 된다.
	 * 
	 * STEP 1. 파일 업로드 API 호출
	 * STEP 2. 이미지 포스팅 API 호출
	 * 
	 * 해당 항목을 셋팅 할 경우 imageUrlList에 셋팅된 항목들은 전부 무시된다.
	 * </pre>
	 * @param storyPhotoUpload
	 */
	public void setStoryPhotoUpload(StoryPhotoUpload storyPhotoUpload) {
		this.storyPhotoUpload = storyPhotoUpload;
	}
	
	/**
	 * <pre>
	 * 포스팅 되는 글에 입력되는 이미지 URL 목록을 가져온다.
	 * 
	 * 스토리 포스팅에 임의의 이미지 URL을 전달 할 수 없습니다. 반드시 업로드 API를 이용하여 업로드한 이미지만 사용할 수 있습니다. - 개발가이드 발췌
	 * </pre>
	 * @return
	 */
	public List<String> getImageUrlList() {
		return imageUrlList;
	}
	/**
	 * <pre>
	 * 포스팅 되는 글에 포함될 이미지 URL 목록 설정
	 * </pre>
	 * @param imageUrlList
	 */
	public void setImageUrlList(List<String> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	/**
	 * <pre>
	 * 포스팅되는 글에 포함될 이미지 URL목록에 데이터를 추가한다.
	 * 
	 * imageUrlList 객체에 데이터를 add 하는 방식으로 동작한다.
	 * </pre>
	 * @param imageUrls
	 */
	public void setImageUrlList(String... imageUrls) {
		if (this.imageUrlList == null) {
			this.imageUrlList = new ArrayList<String>();
		}
		
		for (String imageUrl : imageUrls) {
			this.imageUrlList.add(imageUrl);
		}
	}
	/**
	 * <pre>
	 * 이미지 URL 목록 제거
	 * </pre>
	 */
	public void clearImageUrlList() {
		this.imageUrlList = null;
	}
	
	/**
	 * <pre>
	 * 이미지 URL정보를 Json string 형태로 변환한다.
	 * </pre>
	 * @param prettyPrint
	 * @return
	 */
	public String imageUrlListToJson(boolean prettyPrint) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			if (prettyPrint) {
				return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(imageUrlList);
			} else {
				return objectMapper.writeValueAsString(imageUrlList);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
}
