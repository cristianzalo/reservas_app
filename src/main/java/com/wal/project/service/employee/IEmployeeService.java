package com.wal.project.service.employee;

import java.util.List;

import com.wal.project.dto.employee.EmployeeInsertDTO;
import com.wal.project.dto.employee.EmployeeDTO;


public interface IEmployeeService {
	
	public List<EmployeeDTO> getEmployees();
	
	public EmployeeDTO insertEmployee(EmployeeInsertDTO employee);
	
	public EmployeeDTO updateEmployee(EmployeeInsertDTO employee);
	
	public EmployeeDTO deleteEmployee(Integer id);

}
