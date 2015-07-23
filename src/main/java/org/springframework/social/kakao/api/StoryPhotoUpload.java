package org.springframework.social.kakao.api;

import java.util.ArrayList;
import java.util.List;

public class StoryPhotoUpload {
	private List<String> filePathList;

	/**
	 * <pre>
	 * 파일 경로 목록을 가져온다.
	 * 목록에 데이터가 없다면 null을 반환한다.
	 * </pre>
	 * @return list or null
	 */
	public List<String> getFilePathList() {
		if (this.filePathList == null || this.filePathList.size() == 0) {
			return null;
		}
		return this.filePathList;
	}

	/**
	 * <pre>
	 * 파일 경로 목록 설정
	 * 
	 * 업로드 이미지 크기는 5MB 이하, 갯수는 10개 이하로 제한됩니다. 단, gif 파일은 3MB 이하, 1개 이하로 제한됩니다.
	 * 만일 파일 업로드 대상 수가 2개 이상일때 gif 파일이 포함되어있다면 해당 파일을 제외한 나머지 파일은 업로드 대상에서 제외됩니다.
	 * </pre>
	 * @param filePathList
	 */
	public void setFilePathList(List<String> filePathList) {
		this.filePathList = filePathList;
	}
	/**
	 * <pre>
	 * 파일 경로 목록 list에 데이터를 추가한다.
	 * 
	 * filePathList 객체에 데이터를 add 하는 방식으로 동작한다.
	 * 
	 * 업로드 이미지 크기는 5MB 이하, 갯수는 10개 이하로 제한됩니다. 단, gif 파일은 3MB 이하, 1개 이하로 제한됩니다.
	 * </pre>
	 * @param filePaths
	 */
	public void setFilePathList(String... filePaths) {
		if (this.filePathList == null) {
			this.filePathList = new ArrayList<String>();
		}
		for (String filePath : filePaths)  {
			this.filePathList.add(filePath);
		}
	}
	
	/**
	 * <pre>
	 * 파일 목록 제거 (null 셋팅)
	 * </pre>
	 */
	public void clearFilePathList() {
		this.filePathList = null;
	}
}
