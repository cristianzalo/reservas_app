package com.wal.project.service.customer;

import java.util.List;

import com.wal.project.dto.customer.CustomerInsertDTO;
import com.wal.project.dto.customer.CustomerListItemDTO;
import com.wal.project.models.Customer;

public interface ICustomerService {
	
	public List<CustomerListItemDTO> getCustomers();
	
	public Customer insertCustomer(CustomerInsertDTO customer);
	
	public Customer updateCustomer(CustomerInsertDTO customer);
	
	public Customer deleteCustomer(Integer id);
	

}
