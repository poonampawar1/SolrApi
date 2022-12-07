package com.example.demo.repository;


import java.util.ArrayList;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.SolrProduct;

@Repository
public interface ProductRepository extends SolrCrudRepository<SolrProduct, Integer>{

	

	

}
	