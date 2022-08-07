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
import com.wal.project.dto.customer.CustomerDTO;
import com.wal.project.service.customer.ICustomerService;

@RestController
@RequestMapping("/api/reservas")
public class CustomerController {
	
	
	
	private ICustomerService customerService;
	
	
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getCustomers(){
		
		return new ResponseEntity<List<CustomerDTO>>(customerService.getCustomers(),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/customer")
	public ResponseEntity<CustomerDTO> insertCustomer(@RequestBody CustomerInsertDTO customer){
		
		CustomerDTO customerAdded = customerService.insertCustomer(customer);
		
		
		if (customerAdded == null) {
			
			return new ResponseEntity<CustomerDTO>(customerAdded,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<CustomerDTO>(customerAdded,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerInsertDTO customer){
		
		CustomerDTO customerUpdated = customerService.updateCustomer(customer);
		
		
		if (customerUpdated == null) {
			
			return new ResponseEntity<CustomerDTO>(customerUpdated,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<CustomerDTO>(customerUpdated,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable int id){
		
		CustomerDTO customerDeleted = customerService.deleteCustomer(id);
		
		if (customerDeleted== null) {
			
			return new ResponseEntity<CustomerDTO>(customerDeleted,HttpStatus.BAD_REQUEST);
		}
		
		return  new ResponseEntity<CustomerDTO>(customerDeleted,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
}
