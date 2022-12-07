package com.example.demo.service;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConnectionProvider;
import com.example.demo.model.Product;
import com.example.demo.model.SolrProduct;
import com.example.demo.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService {
	
	
	private static final int SolrProduct = 0;

	private static final int Iterable = 0;

	@Autowired
	ProductRepository repo;
	
	@Autowired
	ConnectionProvider connection;



	@Override
	public Product addProductDb(Product product) {
		// TODO Auto-generated method stub
		Connection con=connection.getcon();
		try {
			PreparedStatement psta=con.prepareStatement("insert into product(id,name,type) values(?,?,?)");
			psta.setInt(1,product.getId());
			psta.setString(2, product.getName());
			psta.setString(3,product.getType());
			psta.execute();
			return product;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Product> getProduct()
	{
		Connection con=connection.getcon();
		ArrayList<Product> list=new ArrayList<>();
		try
		{
			PreparedStatement psta=con.prepareStatement("select * from product");
			
			ResultSet rs=psta.executeQuery();
			
			while(rs.next())
			{
				Product pro=new Product();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setType(rs.getString(3));
				list.add(pro);
				
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String addtoSolr(com.example.demo.model.SolrProduct product) {
		// TODO Auto-generated method stub
		this.repo.save(product);
		
		return "data save in solr";
		
	}

//	@Override
//	public void addDataSolr(ArrayList<SolrProduct> product) {
//		// TODO Auto-generated method stub
//       
//		repo.saveAll(product);
//	}

}