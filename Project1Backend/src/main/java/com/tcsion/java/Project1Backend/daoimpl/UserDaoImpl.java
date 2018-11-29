package com.tcsion.java.Project1Backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcsion.java.Project1Backend.dao.UserDao;
import com.tcsion.java.Project1Backend.dto.User;
@Repository("userDao")  // to create obj. of userdao class in daoimpl 
@Transactional      // to save the data in database through hibernate
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Boolean add(User user) {
try {		
	sessionFactory.getCurrentSession().persist(user);
	return true;
}
catch(Exception e)
{
System.out.println(e);
return false;
	
}
}

	public User getuserByuserId(Long user_id) {
		
		return sessionFactory.getCurrentSession().get(User.class, new Long(user_id));
	}

public Boolean update(User user)
{
	try {		
		sessionFactory.getCurrentSession().update(user);
		return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
		
	}
}
String role;

public Boolean delete(Long user_id) {
	User user= getuserByuserId(user_id);

	return update(user);
}



public String getadminpassw() {
	String user_n="admin@123";
	String hql = "Select U.user_password FROM User U WHERE U.user_role=:user_na";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	query.setParameter("user_na",user_n);
	List<String> results =(List<String>) query.list();
	String str=null;
	for(String s:results)
	{
		return s;
	}
	return str;
}

public String getadminnamee() {
	String user_n="admin@123";
	String hql = "Select U.user_name FROM User U WHERE U.user_role=:user_na";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	query.setParameter("user_na",user_n);
	List<String> results =(List<String>) query.list();
	String str=null;
	for(String s:results)
	{
		return s;
	}
	return str;
}

public Long getidbypass(String pass) {
	String hql = "Select U.user_id FROM User U WHERE U.user_password=:user_pa";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	query.setParameter("user_pa",pass);
	List<Long> results =(List<Long>) query.list();
Long s=	new Long(-1);
  for(Long id:results)
    { 
	s=id;
    }
return s;
}




public Boolean validate(String user_n, String user_pass) {
	String hql = "Select U.user_password FROM User U WHERE U.user_name=:user_na";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	query.setParameter("user_na",user_n);
	List<String> results =(List<String>) query.list();
  for(String str:results)
    { if(str.equals(user_pass))
    {
    	return true;
    }
    }
     return false;
}



public Long validate(String user_n) {
	String hql = "Select U.user_id FROM User U WHERE U.user_name=:user_na";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	query.setParameter("user_na",user_n);
	List<Long> results =(List<Long>) query.list();
	Long iid=new Long(-1);
 for(Long id:results)
    { 
 iid=id;
    }
return iid;
}


}


