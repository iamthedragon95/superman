package com.niit.managedata.dao;

import java.util.List;

import com.niit.managedata.model.Product;

public interface ProductDAO {
	public void save(Product product);
	public void update(Product product);
	public void delete(String productId);
	public Product getProduct(String productId);
	public List getAllProduct();


}
