package org.springframework.social.kakao.api;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class KakaoObject {
	private Map<String, Object> extraData;
	
	public KakaoObject() {
		this.extraData = new HashMap<String, Object>();
	}
	
	@JsonAnyGetter
	public Map<String, Object> getExtraData() {
		return this.extraData;
	}
	
	@JsonAnySetter
	public void add(String key, Object value) {
		this.extraData.put(key, value);
	}
	
	public String toJsonString(boolean prettyPrint) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			if (prettyPrint) {
				return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			} else {
				return objectMapper.writeValueAsString(this);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
