package com.app.Model;

import java.util.Objects;

public class User {
	private String userName;
	private Gender userGender;
	private Integer age;
	
	public User() {
		super();
	}

	public User(String userName, Gender userGender, Integer age) {
		super();
		this.userName = userName;
		this.userGender = userGender;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userGender=" + userGender + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, userGender, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(age, other.age) && userGender == other.userGender
				&& Objects.equals(userName, other.userName);
	}
	
	
}
