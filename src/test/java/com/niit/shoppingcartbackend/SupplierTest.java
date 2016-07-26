package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;

public class SupplierTest {
	public static void main(String[]args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		SupplierDAO supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier= (Supplier) context.getBean("supplier");
	
	
		supplier.setId("CG120");
		supplier.setName("CGName120");
		supplier.setAddress("CGDesc120");
		
		supplierDAO.saveOrUpdate(supplier);
	
		
	}

}

