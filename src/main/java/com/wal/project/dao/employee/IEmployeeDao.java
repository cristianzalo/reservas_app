package com.wal.project.dao.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wal.project.models.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

}
