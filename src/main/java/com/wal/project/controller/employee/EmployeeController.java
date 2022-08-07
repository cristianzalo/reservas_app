package com.wal.project.controller.employee;

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

import com.wal.project.dto.employee.EmployeeInsertDTO;
import com.wal.project.dto.employee.EmployeeDTO;
import com.wal.project.service.employee.IEmployeeService;

@RestController
@RequestMapping("/api/reservas")
public class EmployeeController {
	
	
	private IEmployeeService employeeService;
	
	public EmployeeController(IEmployeeService serviceEmployee) {
		
		this.employeeService = serviceEmployee;
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getEmployees(){
		
		return new ResponseEntity<List<EmployeeDTO>>(employeeService.getEmployees(),HttpStatus.OK);
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> insertEmployee( @RequestBody EmployeeInsertDTO employeeInsert){
		
		EmployeeDTO addedEmployee = employeeService.insertEmployee(employeeInsert);
		
		if(addedEmployee == null) {
			
			return new ResponseEntity<EmployeeDTO>(addedEmployee, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<EmployeeDTO>(addedEmployee, HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/updateEmployee")
	public ResponseEntity<EmployeeDTO> updateEmployee( @RequestBody EmployeeInsertDTO employeeInsert){
		
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeInsert);
		
		if(updatedEmployee == null) {
			
			return new ResponseEntity<EmployeeDTO>(updatedEmployee, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<EmployeeDTO>(updatedEmployee, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable int id){
		
		EmployeeDTO deletedEmployee = employeeService.deleteEmployee(id);
		
		if (deletedEmployee == null) {
			
			return new ResponseEntity<EmployeeDTO>(deletedEmployee, HttpStatus.BAD_REQUEST);
		}
		
		
		return  new ResponseEntity<EmployeeDTO>(deletedEmployee, HttpStatus.ACCEPTED);
		
		
	}
	

}
