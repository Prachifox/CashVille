package com.tcsion.java.Project1Backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcsion.java.Project1Backend.dao.FeedbackDao;
import com.tcsion.java.Project1Backend.dto.Feedbacks;
import com.tcsion.java.Project1Backend.dto.User;

@Repository("feedbackDao") // repository is a container to objects. so we don't have to create object
// anywhere.
@Transactional
public class FeedbacksDaoImpl implements FeedbackDao {

	@Autowired
	private SessionFactory sessionFactory;


	public Boolean add(Feedbacks feedback) {
		
		try {
			sessionFactory.getCurrentSession().persist(feedback);
			return true;
		} catch (Exception e) {
			System.out.println(e); // shows error at console
			return false;
		}
	}

	public List<String> getFeedback() {
		String hql = "Select U.Feedback FROM Feedbacks U ";
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<String> results =(List<String>) query.list();
	return results;
		
	}
	
	
}
