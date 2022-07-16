package com.wal.project.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7358218370844758162L;

	@Id
	private int idEmployee;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String lastname;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private List<Booking> bookings;
	
	public Employee() {}


	public int getIdEmployee() {
		return idEmployee;
	}


	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	
	

}
