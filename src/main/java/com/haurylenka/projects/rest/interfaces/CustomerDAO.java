package com.haurylenka.projects.rest.interfaces;

import java.util.List;

import com.haurylenka.projects.rest.beans.Customer;
import com.haurylenka.projects.rest.exceptions.CustomerDAOException;

public interface CustomerDAO {
	
	List<Customer> getCustomers(String code) throws CustomerDAOException;
	
	Customer getCustomer(String code, int id) throws CustomerDAOException;
	
	Customer addCustomer(String code, Customer customer) 
			throws CustomerDAOException;
	
	Customer updateCustomer(String code, Customer customer) 
			throws CustomerDAOException;
	
	Customer deleteCustomer(String code, int id) throws CustomerDAOException;

}
