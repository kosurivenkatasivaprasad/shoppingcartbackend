package com.niit.shoppingcartbackend.dao;

import java.util.List;

public interface SupplierDAO {
	
	public List<com.niit.shoppingcartbackend.model.Supplier> list();
	
	public com.niit.shoppingcartbackend.model.Supplier get(String id);
	
	public void saveOrUpdate(com.niit.shoppingcartbackend.model.Supplier supplier);
	
	public void delete(String id);

	


	
	

}
