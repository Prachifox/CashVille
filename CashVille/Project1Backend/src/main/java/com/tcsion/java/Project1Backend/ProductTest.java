package com.tcsion.java.Project1Backend;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcsion.java.Project1Backend.dao.ProductDao;
import com.tcsion.java.Project1Backend.dto.Product;

public class ProductTest {
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDao;
	@SuppressWarnings("unused")     // warning ni ayenge only error will stop the project from running
	private Product product;
    SessionFactory sessionFactory;
   
	public ProductTest() {
	//context = new AnnotationConfigApplicationContext();
	//context.scan("com.tcsion.java.Project1Backend");
		//context.refresh();
		//productDao = (ProductDao) context.getBean("productDao");
}
	
	public void addProduct() {    // write the code of the add method of DaoImpl here to check it
		/*Product product=new Product();    
	product.setProduct_available_quantity(5);
	product.setProduct_name("earphones");
	product.setProduct_unit_price(1000);
	product.setEnable(true);
		System.out.println(productDao.add(product));*/
	}
	public void getproduct()
	{
		/*
		Long product_id=new Long(1);
		System.out.println(productDao.getProductByProductid(product_id));*/
	}
	
	public void updateproduct()
	{
		/*Product product=productDao.getProductByProductid(new Long(1));
		product.setProduct_available_quantity(18);
		System.out.println(productDao.update(product));*/
	} 
	public void deleteproduct()
	{
		/*System.out.println(productDao.delete(new Long(1)));*/
	}
	


	public static void main(String[] args) { // main method for project testing
		/*ProductTest t1 = new ProductTest();
		t1.addProduct();*/
		//t1.updateproduct();
		//t1.getproduct();
		//t1.deleteproduct();
		
	}  
}
