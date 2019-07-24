package com.niit.dpt.dao;

import com.niit.dpt.model.User;

public interface UserDao {

	public int insert(User user);
	public User validateUser(String email,String password);
	public User getUserById(int id);
	public int updateUser(User user,int id);
	public User getUserByEmail(String email);
	
}
