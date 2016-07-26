package com.niit.shoppingcartbackend.config;


import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.CategoryDAOImpl;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.ProductDAOImpl;
import com.niit.shoppingcartbackend.dao.SuppierDAOImpl;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.dao.UserDAOImpl;
import com.niit.shoppingcartbackend.model.Category;

@SuppressWarnings("unused")
@Configuration
@ComponentScan("com.niit.shoppingcartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {

	
	
	@Bean(name  ="dataSource")
	public DataSource getDataSource() 
	
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");
		
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
		
	}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		return properties;
	}

@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource){
	LocalSessionFactoryBuilder  sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(com.niit.shoppingcartbackend.model.Category.class);
	sessionBuilder.addAnnotatedClass(com.niit.shoppingcartbackend.model.Supplier.class);
	sessionBuilder.addAnnotatedClass(com.niit.shoppingcartbackend.model.Product.class);
	sessionBuilder.addAnnotatedClass(com.niit.shoppingcartbackend.model.User.class);
	
	return sessionBuilder.buildSessionFactory();
}

@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	org.springframework.orm.hibernate5.HibernateTransactionManager transactionManager = new org.springframework.orm.hibernate5.HibernateTransactionManager(sessionFactory);
	return transactionManager;
	
}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) 
	
	{
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) 
	
	{
		return new SuppierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) 
	
	{
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) 
	
	{
		return new UserDAOImpl(sessionFactory);
	}
	
}

