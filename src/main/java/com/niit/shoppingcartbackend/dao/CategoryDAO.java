package com.niit.shoppingcartbackend.dao;

import java.util.List;

public interface CategoryDAO {
	
	public List<com.niit.shoppingcartbackend.model.Category> list();
	
	public com.niit.shoppingcartbackend.model.Category get(String id);
	
	public void saveOrUpdate(com.niit.shoppingcartbackend.model.Category category);
	
	public void delete(String id);

	


	
	

}
