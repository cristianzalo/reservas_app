package com.wal.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.wal.project.dao.employee.IEmployeeDao;
import com.wal.project.dto.employee.EmployeeInsertDTO;
import com.wal.project.models.Employee;
import com.wal.project.service.employee.impl.EmployeeServiceImpl;

public class EmployeeServiceTest {
	
	
	 IEmployeeDao employeeDao = mock(IEmployeeDao.class);
	
	 EmployeeServiceImpl employeeService;
	
	@BeforeEach
	void setUp() {
		
		employeeService = new EmployeeServiceImpl(employeeDao);
	}
	
	
	@Test
	@DisplayName("get all employees")
	public void getEmployeesTest() {
		
		/*
		List<EmployeeItemListDTO> getListEmployees = new ArrayList<>();
		EmployeeItemListDTO item = new EmployeeItemListDTO();
		item.setIdEmployee(1);
		item.setLastname("ZAPATA");
		item.setName("CRISTIAN");
		
		
		getListEmployees.add(item);
		*/
		
		List<Employee> getListEmployees = new ArrayList<>();
		
		when(employeeDao.findAll()).thenReturn(getListEmployees);
		
		List<Employee> listEmployeesTest = employeeDao.findAll();
		
		assertEquals(0, listEmployeesTest.size());
			
		
		
	}
	
	
	@Test
	public void insertEmployeeFail() {
		
		EmployeeInsertDTO insertData = new EmployeeInsertDTO();
		
		insertData.setIdEmployee(1);
		insertData.setEmployeeName("Cristian");
		insertData.setEmployeeLastname("zapata");
		
		Employee employee = new Employee();
		
		employee.setIdEmployee(1);
		employee.setName("Cristian");
		employee.setLastname("Zapata");
		
		
		Optional<Employee> employeeFinded = Optional.of(employee);
		
		when(employeeDao.findById(1)).thenReturn(employeeFinded);
		
		Employee returnedEmployee = employeeService.insertEmployee(insertData);
		
		assertEquals(null , returnedEmployee );
		
		
	}
	
	
	
	@Test
	public void insertEmployeeSuccess() {
		
		EmployeeInsertDTO insertData = new EmployeeInsertDTO();
		
		insertData.setIdEmployee(1);
		insertData.setEmployeeName("Cristian");
		insertData.setEmployeeLastname("Zapata");
		
		Employee returnedEmployee = new Employee();
		
		Employee employeeReturn = new Employee();
		
		employeeReturn.setIdEmployee(1);
		employeeReturn.setName("Cristian");
		employeeReturn.setLastname("Zapata");
		
		
		Optional<Employee> employeeFinded = Optional.empty();
		
		when(employeeDao.findById(1)).thenReturn(employeeFinded);
		
		when(employeeDao.save(Mockito.any(Employee.class))).thenReturn(employeeReturn);
		
		 returnedEmployee = employeeService.insertEmployee(insertData);
		
		assertEquals(employeeReturn , returnedEmployee );
		
		
	}
	
	

}
