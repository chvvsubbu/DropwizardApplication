package com.subbu.api;

import java.util.List;
import java.util.Optional;



public class User {
	private long id;
	private String name;
	private String friendlyName;
	private List<PartialUser> friends;
	private String currentCity;
	private Integer age;
	private List<College> colleges;
	private List<String> langauges;
	private String mobileNumber;
	
	public User(String name, Integer age) {
		this.name = name;
		this.setAge(age);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public List<PartialUser> getFriends() {
		return friends;
	}
	public void setFriends(List<PartialUser> friends) {
		this.friends = friends;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public List<College> getColleges() {
		return colleges;
	}
	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer integer) {
		this.age = integer;
	}

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
	
	
}
