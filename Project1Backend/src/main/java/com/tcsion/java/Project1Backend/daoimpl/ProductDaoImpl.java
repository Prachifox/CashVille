package com.tcsion.java.Project1Backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcsion.java.Project1Backend.dao.ProductDao;
import com.tcsion.java.Project1Backend.dto.Product;
@Repository("productDao") // repository is a container to objects. so we don't have to create object
// anywhere.
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void deleteproducts(Long id) {
	  try {
	 
	   Product pro=getProductByProductid(id);
	      sessionFactory.getCurrentSession().delete(pro);
	      System.out.println("delete successful");
	  } 
catch (RuntimeException re) {
	    System.out.println("delete failed"+ re);
	    throw re;
	  }
	} 

	public Boolean add(Product product) {
		
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			System.out.println(e); // shows error at console
			return false;
		}
	}

	
	public Product getProductByProductid(Long product_id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, new Long(product_id));
	}

	public Boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			System.out.println(e); // shows error at console
			return false;
		}
	}



	public Long validate(String product_n) {
		String hql = "Select U.product_id FROM Product U WHERE U.product_name=:product_na";
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("product_na",product_n);
		List<Long> results =(List<Long>) query.list();
		Long iid=new Long(-1);
	 for(Long id:results)
	    { 
	 iid=id;
	    }
	return iid;
	}

	
	public Integer getque(String product_n) {
		String hql = "Select U. product_available_quantity FROM Product U WHERE U.product_name=:product_na";
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("product_na",product_n);
		List<Integer> results =(List<Integer>) query.list();
		Integer qque=new Integer(0);
	 for(Integer que:results)
	    { 
	 qque+=que;
	    }
	return qque;
	}


	public Float getp(String pname) {
		String hql = "Select U.product_unit_price FROM Product U WHERE U.product_name=:product_na";
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("product_na",pname);
		List<Float> results =(List<Float>) query.list();
		 Float pp=new  Float(-1);
	 for( Float pric:results)
	    { 
	pp=pric;
	    }
	return pp;
	}
	
public List<String> getl()
{
	String hql = "Select U.product_name FROM Product U ";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	List<String> results =(List<String>) query.list();
return results;
	
}

public List<String> getl4()
{
	String hql = "Select U.productImageLink FROM Product U ";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	List<String> results =(List<String>) query.list();
return results;
	
}

public List<Float> getl2()
{
	String hql = "Select U.product_unit_price FROM Product U ";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	List<Float> results =(List<Float>) query.list();
return results;
	
}

public List<Integer> getl3() {
	String hql = "Select U.product_available_quantity FROM Product U ";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createQuery(hql);
	List<Integer> results =(List<Integer>) query.list();
return results;
}
}
