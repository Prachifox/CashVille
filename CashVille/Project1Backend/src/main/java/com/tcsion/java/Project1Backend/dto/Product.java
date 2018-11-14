package com.tcsion.java.Project1Backend.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long product_id;
private String product_name;
private int product_available_quantity;
private float product_unit_price;
private String productImageLink;



public String getProductImageLink() {
	return productImageLink;
}
public void setProductImageLink(String productImageLink) {
	this.productImageLink = productImageLink;
}
public Long getProduct_id() {
	return product_id;
}
public void setProduct_id(Long product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public int getProduct_available_quantity() {
	return product_available_quantity;
}
public void setProduct_available_quantity(int product_available_quantity) {
	this.product_available_quantity = product_available_quantity;
}
public float getProduct_unit_price() {
	return product_unit_price;
}
public void setProduct_unit_price(float product_unit_price) {
	this.product_unit_price = product_unit_price;
}


}
