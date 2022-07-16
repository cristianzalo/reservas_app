package com.wal.project.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Booking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3074087033883015243L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idBooking;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	@Column
	private Date bookingCreationDate;
	
	@Column
	private Date bookingAtentionDate;
	
	public Booking() {}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getBookingCreationDate() {
		return bookingCreationDate;
	}

	public void setBookingCreationDate(Date bookingCreationDate) {
		this.bookingCreationDate = bookingCreationDate;
	}

	public Date getBookingAtentionDate() {
		return bookingAtentionDate;
	}

	public void setBookingAtentionDate(Date bookingAtentionDate) {
		this.bookingAtentionDate = bookingAtentionDate;
	}
	
	
	
	
	
	
	

}
