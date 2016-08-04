package com.niit.managedata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.managedata.dao.ProductDAO;
import com.niit.managedata.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	public void save(Product product) {
		productDAO.save(product);
	}

	@Transactional
	public void update(Product product) {
		productDAO.update(product);
	}

	@Transactional
	public void delete(String productId) {
		productDAO.delete(productId);
	}

	@Transactional
	public Product getProduct(String productId) {
		return productDAO.getProduct(productId);
	}

	@Transactional
	public List getAllProduct() {
		return productDAO.getAllProduct();
	}



}
