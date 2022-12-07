package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import com.example.demo.repository.ProductRepository;

@SpringBootApplication
@EnableSolrRepositories(basePackageClasses = ProductRepository.class)
public class CrudSolrDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSolrDemoProjectApplication.class, args);
	}

}
