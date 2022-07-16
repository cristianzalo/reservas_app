package com.wal.project.dao.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wal.project.models.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {

	
	
}
