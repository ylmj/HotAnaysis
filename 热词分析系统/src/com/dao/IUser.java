package com.dao;

import com.model.User;

public interface IUser {
	public boolean addUser(String username,String password);
	public User loadUser(String username,String password);

}
