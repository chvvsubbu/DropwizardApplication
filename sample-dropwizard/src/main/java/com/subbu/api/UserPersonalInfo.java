package com.subbu.api;

import java.util.List;
import java.util.Optional;
public class UserPersonalInfo {
	
	private String currentCity;
	private String mobileNumber;
	private List<String> langauges;
	private Integer age;

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<String> getLangauges() {
		return langauges;
	}
	public void setLangauges(List<String> langauges) {
		this.langauges = langauges;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	
}
