package com.tcsion.java.Project1Backend;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcsion.java.Project1Backend.dao.UserDao;
import com.tcsion.java.Project1Backend.dto.User;

public class UserTest {
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;// reference variable of the interface
	@SuppressWarnings("unused")     // warning will not show only error will stop the project from running
	private User user;
    SessionFactory sessionFactory;
   
	public UserTest() {
	/*context = new AnnotationConfigApplicationContext();
	context.scan("com.tcsion.java.Project1Backend");
	context.refresh();
	userDao = (UserDao) context.getBean("userDao"); // now no need to write : userDao=new UserDaoImpl();
*/
	}
	public void addUser() {    // write the code of the add method of DaoImpl here to check it
	User user = new User();     
		user.setuser_password("jaipur");
		user.setUser_name("Divs");
		user.setUser_age(20);
		user.setUser_role("customer");
		user.setUser_contact("7895194529");
	
		System.out.println(userDao.add(user));
	}
	

	public void getuser()
	{
		
		/*Long user_id=new Long(1);
		System.out.println(userDao.getuserByuserId(c));*/
	}
	
	public void updateuser()
	{/*
		User user=userDao.getuserByuserId(new Long(1));
		user.setUser_age(18);
		System.out.println(userDao.update(user));*/
	}
	public void deleteuser()
	{
		/*System.out.println(userDao.delete(new Long(1)));*/
	}

	public static void main(String[] args) { // main method for project testing
		/*UserTest t1 = new UserTest();
		t1.addUser();
		//t1.updateuser();
		//t1.getuser();
		//t1.deleteuser();
		*/
}
}
