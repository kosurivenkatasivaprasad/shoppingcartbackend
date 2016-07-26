package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

public class UserTest {
	public static void main(String[]args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		UserDAO userDAO =(UserDAO) context.getBean("userDAO");
		User user= (User) context.getBean("user");
	
		user.setId("NIIT190");
		user.setName("K V Siva Prasad");
		user.setRollnum("S171108400190");
		user.setMobile("9160828440");
		user.setLocation("Hyderabad");
		
		userDAO.saveOrUpdate(user);
	
		
	}

}

