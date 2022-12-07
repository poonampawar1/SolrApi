package com.example.demo.service;



import java.util.ArrayList;

import com.example.demo.model.Product;
import com.example.demo.model.SolrProduct;

public interface ProductService {

	public Product addProductDb(Product product);
	
//	public void addDataSolr(ArrayList<SolrProduct> product);
	public String  addtoSolr(SolrProduct product);
	
	public ArrayList<Product> getProduct();
	
//	public ArrayList<SolrProduct> getbyNameSolr(String name);
	
	
}
