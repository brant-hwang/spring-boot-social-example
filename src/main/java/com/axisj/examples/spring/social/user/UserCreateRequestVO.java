package com.axisj.examples.spring.social.user;

import org.springframework.social.connect.UserProfile;
import org.springframework.util.StringUtils;

public class UserCreateRequestVO {

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static UserCreateRequestVO fromSocialUserProfile(UserProfile userProfile) {
		UserCreateRequestVO userCreateRequestVO = new UserCreateRequestVO();
		userCreateRequestVO.setEmail(StringUtils.isEmpty(userProfile.getEmail()) ? "" : userProfile.getEmail());
		userCreateRequestVO.setLastName(StringUtils.isEmpty(userProfile.getLastName()) ? "" : userProfile.getLastName());
		userCreateRequestVO.setFirstName(StringUtils.isEmpty(userProfile.getFirstName()) ? "" : userProfile.getFirstName());
		return userCreateRequestVO;
	}
}
