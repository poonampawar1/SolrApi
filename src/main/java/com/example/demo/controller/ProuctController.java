package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.SolrProduct;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@RestController
public class ProuctController {
	
	@Autowired
	ProductService service;
	
	
	
	  
	@PostMapping("/saveproduct")
	public Product saveProduct(@RequestBody Product product)
	{
	 Product pro=this.service.addProductDb(product);
	 SolrProduct solrproduct=new SolrProduct();
	  solrproduct.setId(pro.getId());
	  solrproduct.setName(pro.getName());
	  solrproduct.setType(pro.getType());
	  String response=this.service.addtoSolr(solrproduct);
	  System.out.println(""+response);
	return pro;
					
	}
	
	@GetMapping("/getproduct")
	public ArrayList<Product> getproduct()
	{
		ArrayList<Product> list=this.service.getProduct();
//		System.out.println("get data from database");
//		ArrayList<SolrProduct> list2=new ArrayList<>();
//      for(int i=0;i<list.size();i++)
//      {
//    	  SolrProduct p=new SolrProduct();
//    	  p.setId(list.get(i).getId());
//    	  p.setName(list.get(i).getName());
//    	  p.setType(list.get(i).getType());
//    	  list2.add(p);
//    	  
//      }

     // this.service.addDataSolr(list2);
      System.out.println("add data in solr");
      return list;

	}
	

}
