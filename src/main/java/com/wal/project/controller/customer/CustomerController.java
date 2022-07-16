package com.wal.project.controller.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wal.project.dto.customer.CustomerInsertDTO;
import com.wal.project.dto.customer.CustomerListItemDTO;
import com.wal.project.models.Customer;
import com.wal.project.service.customer.ICustomerService;

@RestController
@RequestMapping("/api/reservas")
public class CustomerController {
	
	
	
	private ICustomerService customerService;
	
	
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerListItemDTO>> getCustomers(){
		
		return new ResponseEntity<List<CustomerListItemDTO>>(customerService.getCustomers(),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> insertCustomer(@RequestBody CustomerInsertDTO customer){
		
		Customer customerAdded = customerService.insertCustomer(customer);
		
		
		if (customerAdded == null) {
			
			return new ResponseEntity<Customer>(customerAdded,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<Customer>(customerAdded,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerInsertDTO customer){
		
		Customer customerUpdated = customerService.updateCustomer(customer);
		
		
		if (customerUpdated == null) {
			
			return new ResponseEntity<Customer>(customerUpdated,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<Customer>(customerUpdated,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
		
		Customer customerDeleted = customerService.deleteCustomer(id);
		
		if (customerDeleted== null) {
			
			return new ResponseEntity<Customer>(customerDeleted,HttpStatus.BAD_REQUEST);
		}
		
		return  new ResponseEntity<Customer>(customerDeleted,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
}
