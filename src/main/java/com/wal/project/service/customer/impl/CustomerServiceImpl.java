package com.wal.project.service.customer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wal.project.dao.customer.ICustomerDao;
import com.wal.project.dto.customer.CustomerInsertDTO;
import com.wal.project.dto.customer.CustomerListItemDTO;
import com.wal.project.models.Customer;
import com.wal.project.service.customer.ICustomerService;



@Service
public class CustomerServiceImpl implements ICustomerService {
	
	
	private ICustomerDao customerDao;
	
	public CustomerServiceImpl(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<CustomerListItemDTO> getCustomers() {
		List<Customer> customers = customerDao.findAll();
		
		List<CustomerListItemDTO> customersListDTO = new ArrayList<>();
		
		for (Customer customer : customers) {
			
			CustomerListItemDTO customerDto = new CustomerListItemDTO();
			
			customerDto.setIdCustomer(customer.getIdCustomer());
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setUserCustomer(customer.getUserCustomer());
			customerDto.setPassword(customer.getPassword());
			
			customersListDTO.add(customerDto);
			
		}
	
	
		return customersListDTO;
	}
	
	

	@Override
	public Customer insertCustomer(CustomerInsertDTO customer) {
		Customer customerInsert;
		
		Optional<Customer> customerExist = customerDao.findById(customer.getIdCustomer());
		
		if (!customerExist.isPresent()) {
			
			customerInsert = new Customer();
			
			customerInsert.setIdCustomer(customer.getIdCustomer());
			customerInsert.setCustomerName(customer.getCustomerName());
			customerInsert.setUserCustomer(customer.getCustomerUser());
			customerInsert.setPassword(customer.getCustomerPasword());
			
			
			customerInsert = customerDao.save(customerInsert);
			
		}else {
			
			customerInsert = null;
			
		}
		
		return customerInsert;
	}

	@Override
	public Customer updateCustomer(CustomerInsertDTO customer) {
		Customer customerUpdate;
		
		Optional<Customer> customerExist = customerDao.findById(customer.getIdCustomer());
		
		if (customerExist.isPresent()) {
			
			customerUpdate = customerExist.get();
			
			customerUpdate.setIdCustomer(customer.getIdCustomer());
			customerUpdate.setCustomerName(customer.getCustomerName());
			customerUpdate.setUserCustomer(customer.getCustomerUser());
			customerUpdate.setPassword(customer.getCustomerPasword());
			
			
			customerUpdate = customerDao.save(customerUpdate);
			
		}else {
			
			customerUpdate = null;
			
		}
		
		return customerUpdate;
	}
	
	
	
	

	@Override
	public Customer deleteCustomer(Integer id) {
		Optional<Customer> customerDelete = customerDao.findById(id);
		
		Customer customerDeleted;
		
		if (customerDelete.isPresent()) {
			
			customerDeleted = customerDelete.get();
			
			customerDao.deleteById(id);
			
		}else {
			
			customerDeleted = null;
		}
		
		// TODO Auto-generated method stub
		return customerDeleted;
	}
	

	
	
	
	

}
