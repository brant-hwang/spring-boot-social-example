package org.springframework.social.kakao.api;

public class MyStoryLike {
	private String emotion;
	private MyStoryWriter actor;
	public String getEmotion() {
		return emotion;
	}
	public MyStoryWriter getActor() {
		return actor;
	}
	MyStoryLike(){}
}
