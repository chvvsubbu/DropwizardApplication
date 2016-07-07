package com.subbu.dataresource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.subbu.api.User;

public class UserResource {
	Map<Long, User> userMap;
	private final AtomicLong counter = new AtomicLong();
	public UserResource() {
		userMap = new HashMap<Long, User>();
	}
	
	public User getProfile(long id)
	{
		return userMap.get(id);
		
	}
	
	public void createProfile(User user)
	{
		long id = counter.incrementAndGet();
		user.setId(id);
		userMap.put(id, user);
	}
	
	public void update(User user)
	{
		userMap.put(user.getId(), user);
	}

}
