package com.wal.project.service.customer;

import java.util.List;

import com.wal.project.dto.customer.CustomerDTO;
import com.wal.project.dto.customer.CustomerInsertDTO;

public interface ICustomerService {
	
	public List<CustomerDTO> getCustomers();
	
	public CustomerDTO insertCustomer(CustomerInsertDTO customer);
	
	public CustomerDTO updateCustomer(CustomerInsertDTO customer);
	
	public CustomerDTO deleteCustomer(Integer id);
	

}
