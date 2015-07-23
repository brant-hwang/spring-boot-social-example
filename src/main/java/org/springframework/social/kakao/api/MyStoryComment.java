package org.springframework.social.kakao.api;

public class MyStoryComment {
	private String text;
	private MyStoryWriter writer;
	public String getText() {
		return text;
	}
	public MyStoryWriter getWriter() {
		return writer;
	}
	MyStoryComment(){}
}
