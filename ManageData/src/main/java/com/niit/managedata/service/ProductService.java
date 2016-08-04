package com.niit.managedata.service;

import java.util.List;

import com.niit.managedata.model.Product;

public interface ProductService {
	public void save(Product product);
	public void update(Product product);
	public void delete(String productId);
	public Product getProduct(String productId);
	public List getAllProduct();


}
