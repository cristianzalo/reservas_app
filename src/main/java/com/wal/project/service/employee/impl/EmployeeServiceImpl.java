package com.wal.project.service.employee.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wal.project.dao.employee.IEmployeeDao;
import com.wal.project.dto.employee.EmployeeInsertDTO;
import com.wal.project.dto.employee.EmployeeDTO;
import com.wal.project.models.Employee;
import com.wal.project.service.employee.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	
	private IEmployeeDao employeeDao;
	
	public EmployeeServiceImpl(IEmployeeDao daoEmployee) {
		
		this.employeeDao = daoEmployee;
		
	}
	
	

	@Override
	public List<EmployeeDTO> getEmployees() {
		List<Employee> listEmployee = employeeDao.findAll();
		
		List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();
		
		for (Employee employee : listEmployee) {
			
			EmployeeDTO employeeItem = new EmployeeDTO();
			
			employeeItem.setIdEmployee(employee.getIdEmployee());
			employeeItem.setName(employee.getName());
			
			employeeItem.setLastname(employee.getLastname());
			
			listEmployeeDTO.add(employeeItem);
		}
		
		return listEmployeeDTO;
	}
	
	

	@Override
	public EmployeeDTO insertEmployee(EmployeeInsertDTO employee) {
		Employee employeeInsert;
		
		EmployeeDTO employeeDTOReturn;
		
		Optional<Employee> employeeExist = employeeDao.findById(employee.getIdEmployee());
		
		
		if (!employeeExist.isPresent()) {

			
			employeeInsert = new Employee();
			
			employeeInsert.setIdEmployee( employee.getIdEmployee());
			employeeInsert.setName(employee.getEmployeeName());
			employeeInsert.setLastname(employee.getEmployeeLastname());
			
			
			employeeInsert = employeeDao.save(employeeInsert);
			
			employeeDTOReturn = new EmployeeDTO();
			
			employeeDTOReturn.setIdEmployee(employeeInsert.getIdEmployee());
			employeeDTOReturn.setName(employeeInsert.getName());
			employeeDTOReturn.setLastname(employeeInsert.getLastname());
			
			
		} else {
			
			employeeDTOReturn= null;
		}
		
		
		
		return employeeDTOReturn;
	}
	
	
	
	

	@Override
	public EmployeeDTO updateEmployee(EmployeeInsertDTO employee) {
		Employee employeeUpdate;
		
		EmployeeDTO employeeDTOReturn;
		
		Optional<Employee> employeeExist = employeeDao.findById(employee.getIdEmployee());
		
		
		if (employeeExist.isPresent()) {

			
			employeeUpdate =employeeExist.get();
			
			employeeUpdate.setIdEmployee( employee.getIdEmployee());
			employeeUpdate.setName(employee.getEmployeeName());
			employeeUpdate.setLastname(employee.getEmployeeLastname());
			
			
			employeeUpdate = employeeDao.save(employeeUpdate);
			
			employeeDTOReturn = new EmployeeDTO();
			
			employeeDTOReturn.setIdEmployee(employeeUpdate.getIdEmployee());
			employeeDTOReturn.setName(employeeUpdate.getName());
			employeeDTOReturn.setLastname(employeeUpdate.getLastname());
			
		} else {
			
			employeeDTOReturn= null;
		}
		
	
		
		return employeeDTOReturn;
	}
	
	
	

	@Override
	public EmployeeDTO deleteEmployee(Integer id) {
		
		Optional<Employee> employeeDelete = employeeDao.findById(id);
		
		Employee employeeDeleted ;
		
		EmployeeDTO employeeDTOReturn;
		
		
		if(employeeDelete.isPresent()) {
			
			employeeDeleted =  employeeDelete.get();
			
			employeeDTOReturn = new EmployeeDTO();
			
			employeeDTOReturn.setIdEmployee(employeeDeleted.getIdEmployee());
			employeeDTOReturn.setName(employeeDeleted.getName());
			employeeDTOReturn.setLastname(employeeDeleted.getLastname());
			
			
			employeeDao.deleteById(id);
		} else {
			
			employeeDTOReturn= null;
		}
		
		return employeeDTOReturn;
	}

	
	
	
}
