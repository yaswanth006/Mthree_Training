package com.mthree.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mthree.models.Product;

public class ProductDAO {
	
	
	private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	private List<Product> products;
	
	
	public ProductDAO() {
		
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				this.con = DriverManager.getConnection("jdbc:mysql://localhost/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				
			}
			catch(Exception e) {
				
				System.out.println(e);
				
			}
	
	}
	
		
	public List<Product> getAllProducts(){
		
		this.products = new ArrayList<>();
		  
		  
		try {
			
			this.pst = this.con.prepareStatement("SELECT * from product");
			
			this.rs = this.pst.executeQuery();
			
			
			while(rs.next()) {
				
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		return this.products;
		
	}
	
	
	
	public int addToCart(int productId){
		
		int i = 0;
		  
		try {
			
			this.pst = this.con.prepareStatement("INSERT into cart(product_id,customer_id) VALUES(?,?)");
			
			this.pst.setInt(1,productId);
			this.pst.setInt(2,1);
			i = this.pst.executeUpdate();
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		return i;
		
	}
	
	
	
	
    public int findCartSize(){
		
		int size = 0;
		  
		  
		try {
			
			this.pst = this.con.prepareStatement("SELECT count(*) from cart WHERE customer_id = 1");
			
			this.rs = this.pst.executeQuery();
			
			if(rs.next()) {
				size = rs.getInt(1);
			}
			
			
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		return size;
		
	}
	
	

}
