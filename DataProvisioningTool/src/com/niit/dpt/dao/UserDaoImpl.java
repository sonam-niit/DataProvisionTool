package com.niit.dpt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.dpt.config.DBConfig;
import com.niit.dpt.model.User;

public class UserDaoImpl implements UserDao {

	Connection connection=null;
	PreparedStatement pst;
	
	public UserDaoImpl()
	{
		connection = DBConfig.connect();
	}
	@Override
	public int insert(User user) {
		int count=0;
		try {
			pst = connection.prepareStatement("insert into user(name,phone,simType,address,email,password) values(?,?,?,?,?,?)");
			//pst.setInt(1, user.getUid());
			pst.setString(1, user.getName());
			pst.setString(2, user.getPhone());
			pst.setString(3, user.getSimType());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getPassword());
	
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public User validateUser(String email, String password) {
		User user=null;
		try {
			pst = connection.prepareStatement("select * from user where email=? and password=?");
			pst.setString(1, email);
			pst.setString(2,password);
			
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				user=new User();
				user.setUid(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPhone(resultSet.getString(3));
				user.setSimType(resultSet.getString(4));
				user.setAddress(resultSet.getString(5));
				user.setEmail(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return user;
	}

	@Override
	public User getUserById(int id) {
		User user=new User();
		try {
			pst = connection.prepareStatement("select * from user where uid=?");
			pst.setInt(1, id);
			
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				user.setUid(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPhone(resultSet.getString(3));
				user.setSimType(resultSet.getString(4));
				user.setAddress(resultSet.getString(5));
				user.setEmail(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public User getUserByEmail(String email) {
		User user=new User();
		try {
			pst = connection.prepareStatement("select * from user where email=?");
			pst.setString(1, email);
			
			ResultSet resultSet=pst.executeQuery();
			while(resultSet.next())
			{
				user.setUid(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPhone(resultSet.getString(3));
				user.setSimType(resultSet.getString(4));
				user.setAddress(resultSet.getString(5));
				user.setEmail(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int updateUser(User user, int id) {
		int count=0;
		try {
			pst = connection.prepareStatement("update user set name=?,phone=?,simType=?,address=?,email=?,password=? where uid=?");
			pst.setInt(7, id);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPhone());
			pst.setString(3, user.getSimType());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getPassword());
	
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
