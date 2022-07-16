package com.wal.project.service.employee;

import java.util.List;

import com.wal.project.dto.employee.EmployeeInsertDTO;
import com.wal.project.dto.employee.EmployeeItemListDTO;
import com.wal.project.models.Employee;

public interface IEmployeeService {
	
	public List<EmployeeItemListDTO> getEmployees();
	
	public Employee insertEmployee(EmployeeInsertDTO employee);
	
	public Employee updateEmployee(EmployeeInsertDTO employee);
	
	public Employee deleteEmployee(Integer id);

}
