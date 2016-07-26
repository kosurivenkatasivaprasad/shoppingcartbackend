package com.niit.shoppingcartbackend.dao;

import java.util.List;

public interface UserDAO {
	
	public List<com.niit.shoppingcartbackend.model.User> list();
	
	public com.niit.shoppingcartbackend.model.User get(String id);
	
	public void saveOrUpdate(com.niit.shoppingcartbackend.model.User user);
	
	public void delete(String id);

	


	
	

}
