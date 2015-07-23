package org.springframework.social.kakao.api;

import java.io.Serializable;
import java.util.List;

public class MyStory extends KakaoObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String url;
	private String media_type;
	private String created_at;
	private int comment_count;
	private int like_count;
	private String content;
	private List<MyStoryMedia> media;
	private List<MyStoryComment> comments;
	private List<MyStoryLike> likes;
	
	public String getId() {
		return id;
	}
	public String getUrl() {
		return url;
	}
	public String getMedia_type() {
		return media_type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public int getComment_count() {
		return comment_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public String getContent() {
		return content;
	}
	public List<MyStoryMedia> getMedia() {
		return media;
	}
	public List<MyStoryComment> getComments() {
		return comments;
	}
	public List<MyStoryLike> getLikes() {
		return likes;
	}
	
	MyStory(){}
}
