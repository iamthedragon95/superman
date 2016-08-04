package com.niit.managedata.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.managedata.model.Product;
import com.niit.managedata.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/")
	public String gohome(){
		return "index";
	}
	
	@RequestMapping("/prodata")
	public String setupForm(Map<String, Object> map){
		Product product = new Product();
		map.put("product", product);
		map.put("productList", productService.getAllProduct());
		return "products";
	}
	@RequestMapping(value="/products.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Product product, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Product productResult = new Product();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "save":
			productService.save(product);
			productResult = product;
			break;
		case "update":
			productService.update(product);
			productResult = product;
			break;
		case "delete":
			productService.delete(product.getProductId());
			productResult = new Product();
			break;
		case "search":
			Product searchedProduct = productService.getProduct(product.getProductId());
			productResult = searchedProduct!=null ? searchedProduct : new Product();
			break;
		}
		map.put("product", productResult);
		map.put("productList", productService.getAllProduct());
		return "index";
	}


}
