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
import com.wal.project.dto.employee.EmployeeItemListDTO;
import com.wal.project.models.Employee;
import com.wal.project.service.employee.IEmployeeService;

@RestController
@RequestMapping("/api/reservas")
public class EmployeeController {
	
	
	private IEmployeeService employeeService;
	
	public EmployeeController(IEmployeeService serviceEmployee) {
		
		this.employeeService = serviceEmployee;
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeItemListDTO>> getEmployees(){
		
		return new ResponseEntity<List<EmployeeItemListDTO>>(employeeService.getEmployees(),HttpStatus.OK);
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> insertEmployee( @RequestBody EmployeeInsertDTO employeeInsert){
		
		Employee addedEmployee = employeeService.insertEmployee(employeeInsert);
		
		if(addedEmployee == null) {
			
			return new ResponseEntity<Employee>(addedEmployee, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Employee>(addedEmployee, HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee( @RequestBody EmployeeInsertDTO employeeInsert){
		
		Employee updatedEmployee = employeeService.updateEmployee(employeeInsert);
		
		if(updatedEmployee == null) {
			
			return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		
		Employee deletedEmployee = employeeService.deleteEmployee(id);
		
		if (deletedEmployee == null) {
			
			return new ResponseEntity<Employee>(deletedEmployee, HttpStatus.BAD_REQUEST);
		}
		
		
		return  new ResponseEntity<Employee>(deletedEmployee, HttpStatus.ACCEPTED);
		
		
	}
	

}
