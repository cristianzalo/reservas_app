package com.wal.project.service.employee.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wal.project.dao.employee.IEmployeeDao;
import com.wal.project.dto.employee.EmployeeInsertDTO;
import com.wal.project.dto.employee.EmployeeItemListDTO;
import com.wal.project.models.Employee;
import com.wal.project.service.employee.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	
	private IEmployeeDao employeeDao;
	
	public EmployeeServiceImpl(IEmployeeDao daoEmployee) {
		
		this.employeeDao = daoEmployee;
		
	}
	
	

	@Override
	public List<EmployeeItemListDTO> getEmployees() {
		List<Employee> listEmployee = employeeDao.findAll();
		
		List<EmployeeItemListDTO> listEmployeeDTO = new ArrayList<>();
		
		for (Employee employee : listEmployee) {
			
			EmployeeItemListDTO employeeItem = new EmployeeItemListDTO();
			
			employeeItem.setIdEmployee(employee.getIdEmployee());
			employeeItem.setName(employee.getName());
			
			employeeItem.setLastname(employee.getLastname());
			
			listEmployeeDTO.add(employeeItem);
		}
		
		return listEmployeeDTO;
	}
	
	

	@Override
	public Employee insertEmployee(EmployeeInsertDTO employee) {
		Employee employeeInsert;
		
		Optional<Employee> employeeExist = employeeDao.findById(employee.getIdEmployee());
		
		
		if (!employeeExist.isPresent()) {

			
			employeeInsert = new Employee();
			
			employeeInsert.setIdEmployee( employee.getIdEmployee());
			employeeInsert.setName(employee.getEmployeeName());
			employeeInsert.setLastname(employee.getEmployeeLastname());
			
			
			employeeInsert = employeeDao.save(employeeInsert);
		} else {
			
			employeeInsert= null;
		}
		
		
		
		return employeeInsert;
	}
	
	
	
	

	@Override
	public Employee updateEmployee(EmployeeInsertDTO employee) {
		Employee employeeUpdate;
		
		Optional<Employee> employeeExist = employeeDao.findById(employee.getIdEmployee());
		
		
		if (employeeExist.isPresent()) {

			
			employeeUpdate =employeeExist.get();
			
			employeeUpdate.setIdEmployee( employee.getIdEmployee());
			employeeUpdate.setName(employee.getEmployeeName());
			employeeUpdate.setLastname(employee.getEmployeeLastname());
			
			
			employeeUpdate = employeeDao.save(employeeUpdate);
		} else {
			
			employeeUpdate= null;
		}
		
	
		
		return employeeUpdate;
	}
	
	
	

	@Override
	public Employee deleteEmployee(Integer id) {
		
		Optional<Employee> employeeDelete = employeeDao.findById(id);
		
		Employee employeeDeleted ;
		
		if(employeeDelete.isPresent()) {
			
			employeeDeleted =  employeeDelete.get();
			
			employeeDao.deleteById(id);
		} else {
			
			employeeDeleted= null;
		}
		
		return employeeDeleted;
	}

	
	
	
}
