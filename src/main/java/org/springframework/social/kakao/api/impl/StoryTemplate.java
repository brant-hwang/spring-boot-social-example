package org.springframework.social.kakao.api.impl;

import org.springframework.core.io.FileSystemResource;
import org.springframework.social.kakao.api.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class StoryTemplate extends AbstractKakaoOperations implements StoryOperation {
	private final RestTemplate restTemplate;
	
	public StoryTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}

	public KakaoStoryProfile isStoryUser() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/api/story/isstoryuser"), KakaoStoryProfile.class);
	}

	public KakaoStoryProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildApiUri("/v1/api/story/profile"), KakaoStoryProfile.class);
	}
	
	public StoryPostingResult postNote(StoryNotePosting storyNotePosting) {
		requireAuthorization();
		//파라메터 생성하기
		MultiValueMap<String, Object> param = postingCommonParamSetting(storyNotePosting);
		param.set("content", storyNotePosting.getContent());
		
		//API 요청
		return restTemplate.postForObject(buildApiUri("/v1/api/story/post/note"), param, StoryPostingResult.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> uploadPhoto(StoryPhotoUpload storyPhotoUpload) {
		List<String> filePathList = storyPhotoUpload.getFilePathList();
		
		//업로드 대상 이미지 파일에 대하여 gif animation 파일이 있는지 조사하여 gif animation 파일이 존재 한다면 
		//해당 gif animation 이미지 이외의 다른 이미지 등록 보류 처리 방안 결정 필요.
		// 1. 라이브러리차원에서 해당 처리를 지원 할것인가. (업로드 직전 필터링)
		// 2. 해당 라이브러리를 활용하는 프로그램 소스상에서 해당 처리를 구현하도록 할것인가.
		MultiValueMap<String, FileSystemResource> param = new LinkedMultiValueMap<String, FileSystemResource>();
		for (String filePath : filePathList) {
			param.add("file", new FileSystemResource(filePath));
		}
		
		return restTemplate.postForObject(buildApiUri("/v1/api/story/upload/multi"), param, List.class);
	}
	
	public StoryPostingResult postPhoto(StoryPhotoPosting storyPhotoPosting) {
		requireAuthorization();
		if (storyPhotoPosting.getStoryPhotoUpload() != null) {
			//이미지 업로드 호출하여 결과 대체
			List<String> imageUrlList = uploadPhoto(storyPhotoPosting.getStoryPhotoUpload());
			storyPhotoPosting.setImageUrlList(imageUrlList);
		}
		
		MultiValueMap<String, Object> param = postingCommonParamSetting(storyPhotoPosting);
		param.set("image_url_list", storyPhotoPosting.imageUrlListToJson(false));
		param.set("content", storyPhotoPosting.getContent());
		
		return restTemplate.postForObject(buildApiUri("/v1/api/story/post/photo"), param, StoryPostingResult.class);
	}
	
	public StoryLinkInfo linkInfo(String url) {
		requireAuthorization();
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("url", url);
		
		return restTemplate.getForObject(buildApiUri("/v1/api/story/linkinfo", param), StoryLinkInfo.class);
	}

	public StoryPostingResult postLink(StoryLinkPosting storyLinkPosting) {
		requireAuthorization();
		//url 정보 체크. url 값이 있다면 linkInfo 메서드 호출
		if (!StringUtils.isEmpty(storyLinkPosting.getUrl())) {
			storyLinkPosting.setStoryLinkInfo(linkInfo(storyLinkPosting.getUrl()));
		}
		
		//파라메터 셋팅
		MultiValueMap<String, Object> param = postingCommonParamSetting(storyLinkPosting);
		param.set("link_info", storyLinkPosting.getStoryLinkInfo().toJsonString(false));
		param.set("content", storyLinkPosting.getContent());
		
		return restTemplate.postForObject(buildApiUri("/v1/api/story/post/link"), param, StoryPostingResult.class);
	}
	
	private MultiValueMap<String, Object> postingCommonParamSetting(AbstractStoryPosting abstractStoryPosting) {
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		
		param.set("permission", abstractStoryPosting.getPermission());
		param.set("enable_share", abstractStoryPosting.isEnableShare());
		if (!StringUtils.isEmpty(abstractStoryPosting.getAndroidExecParam())) {
			param.set("android_exec_param", abstractStoryPosting.getAndroidExecParam());
		}
		if (!StringUtils.isEmpty(abstractStoryPosting.getIosExecParam())) {
			param.set("ios_exec_param", abstractStoryPosting.getIosExecParam());
		}
		if (!StringUtils.isEmpty(abstractStoryPosting.getAndroidMarketParam())) {
			param.set("android_market_param", abstractStoryPosting.getAndroidMarketParam());
		}
		if (!StringUtils.isEmpty(abstractStoryPosting.getIosMarketParam())) {
			param.set("ios_market_param", abstractStoryPosting.getIosMarketParam());
		}
		
		return param;
	}
	
	public MyStory myStory(String id) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("id", id);
		
		return restTemplate.getForObject(buildApiUri("/v1/api/story/mystory", param), MyStory.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<MyStory> myStories(String lastId) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		if (lastId != null) {
			param.set("last_id", lastId);
		}
		
		return restTemplate.getForObject(buildApiUri("/v1/api/story/mystories", param), List.class);
	}
	
	public void deleteMyStory(String id) {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.set("id", id);
		
		restTemplate.delete(buildApiUri("/v1/api/story/delete/mystory", param));
	}
}
