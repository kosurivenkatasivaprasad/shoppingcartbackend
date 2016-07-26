package com.niit.shoppingcartbackend.dao;

import java.util.List;

public interface ProductDAO {
	
	public List<com.niit.shoppingcartbackend.model.Product> list();
	
	public com.niit.shoppingcartbackend.model.Product get(String id);
	
	public void saveOrUpdate(com.niit.shoppingcartbackend.model.Product product);
	
	public void delete(String id);

	


	
	

}
