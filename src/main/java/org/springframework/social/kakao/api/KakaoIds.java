package org.springframework.social.kakao.api;

import java.io.Serializable;
import java.util.List;

public class KakaoIds extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Long> result;
	
	private int totalCount;
	
	KakaoPages pages;
	
	public List<Long> getResult() {
		return result;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public KakaoPages getPages() {
		return pages;
	}
	
	KakaoIds(){}
}
