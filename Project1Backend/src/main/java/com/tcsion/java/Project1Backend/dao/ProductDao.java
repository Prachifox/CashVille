package com.tcsion.java.Project1Backend.dao;

import java.util.List;

import com.tcsion.java.Project1Backend.dto.Product;

public interface ProductDao {


	Boolean add(Product product);
	Product getProductByProductid(Long product_id);
	Boolean update(Product product);
	 Long validate(String product_name);
	 Integer getque(String pname);
	 Float getp(String pname);
	 public List<String> getl();
	 public List<Float> getl2();
	 public List<Integer> getl3();
	 public List<String> getl4();
	 	public void deleteproducts(Long id);
}
