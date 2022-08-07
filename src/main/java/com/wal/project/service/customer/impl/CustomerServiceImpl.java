package com.wal.project.service.customer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wal.project.dao.customer.ICustomerDao;
import com.wal.project.dto.customer.CustomerInsertDTO;
import com.wal.project.dto.customer.CustomerDTO;
import com.wal.project.models.Customer;
import com.wal.project.service.customer.ICustomerService;



@Service
public class CustomerServiceImpl implements ICustomerService {
	
	
	private ICustomerDao customerDao;
	
	public CustomerServiceImpl(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<CustomerDTO> getCustomers() {
		List<Customer> customers = customerDao.findAll();
		
		List<CustomerDTO> customersListDTO = new ArrayList<>();
		
		for (Customer customer : customers) {
			
			CustomerDTO customerDto = new CustomerDTO();
			
			customerDto.setIdCustomer(customer.getIdCustomer());
			customerDto.setCustomerName(customer.getCustomerName());
			customerDto.setUserCustomer(customer.getUserCustomer());
			customerDto.setPassword(customer.getPassword());
			
			customersListDTO.add(customerDto);
			
		}
	
	
		return customersListDTO;
	}
	
	

	@Override
	public CustomerDTO insertCustomer(CustomerInsertDTO customer) {
		Customer customerInsert;
		
		CustomerDTO customerDTOReturn;
		
		Optional<Customer> customerExist = customerDao.findById(customer.getIdCustomer());
		
		if (!customerExist.isPresent()) {
			
			customerInsert = new Customer();
			
			customerInsert.setIdCustomer(customer.getIdCustomer());
			customerInsert.setCustomerName(customer.getCustomerName());
			customerInsert.setUserCustomer(customer.getCustomerUser());
			customerInsert.setPassword(customer.getCustomerPasword());
			
			
			customerInsert = customerDao.save(customerInsert);
			
			customerDTOReturn = new CustomerDTO();
			
			customerDTOReturn.setIdCustomer(customerInsert.getIdCustomer());
			customerDTOReturn.setCustomerName(customerInsert.getCustomerName());
			customerDTOReturn.setUserCustomer(customerInsert.getUserCustomer());
			customerDTOReturn.setPassword(customerInsert.getPassword());
			
			
			
		}else {
			
			customerDTOReturn = null;
			
		}
		
		return customerDTOReturn;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerInsertDTO customer) {
		Customer customerUpdate;
		
		CustomerDTO customerDTOReturn;
		
		Optional<Customer> customerExist = customerDao.findById(customer.getIdCustomer());
		
		if (customerExist.isPresent()) {
			
			customerUpdate = customerExist.get();
			
			customerUpdate.setIdCustomer(customer.getIdCustomer());
			customerUpdate.setCustomerName(customer.getCustomerName());
			customerUpdate.setUserCustomer(customer.getCustomerUser());
			customerUpdate.setPassword(customer.getCustomerPasword());
			
			
			customerUpdate = customerDao.save(customerUpdate);
			
			customerDTOReturn = new CustomerDTO();
			
			customerDTOReturn.setIdCustomer(customerUpdate.getIdCustomer());
			customerDTOReturn.setCustomerName(customerUpdate.getCustomerName());
			customerDTOReturn.setUserCustomer(customerUpdate.getUserCustomer());
			customerDTOReturn.setPassword(customerUpdate.getPassword());
			
		}else {
			
			customerDTOReturn = null;
			
		}
		
		return customerDTOReturn;
	}
	
	
	
	

	@Override
	public CustomerDTO deleteCustomer(Integer id) {
		Optional<Customer> customerDelete = customerDao.findById(id);
		
		CustomerDTO customerDTOReturn;
		
		Customer customerDeleted;
		
		if (customerDelete.isPresent()) {
			
			customerDeleted = customerDelete.get();
			
			
			customerDTOReturn = new CustomerDTO();
			
			customerDTOReturn.setIdCustomer(customerDeleted.getIdCustomer());
			customerDTOReturn.setCustomerName(customerDeleted.getCustomerName());
			customerDTOReturn.setUserCustomer(customerDeleted.getUserCustomer());
			customerDTOReturn.setPassword(customerDeleted.getPassword());
			
			
			customerDao.deleteById(id);
			
		}else {
			
			customerDTOReturn = null;
		}
		
		// TODO Auto-generated method stub
		return customerDTOReturn;
	}
	

	
	
	
	

}
