package com.tcsion.java.Project1Backend.dao;

import com.tcsion.java.Project1Backend.dto.User;

public interface UserDao {
	Boolean add(User user);
	User getuserByuserId(Long user_id);
	
	 Boolean update(User user);
	 Boolean delete(Long user_id);
     Boolean validate(String user_name,String user_password);
 	public String getadminpassw();
	public String getadminnamee();
	public Long getidbypass(String pass);
	public Long validate(String user_n);
}
