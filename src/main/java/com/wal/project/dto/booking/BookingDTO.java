package com.wal.project.dto.booking;

import java.util.Date;

public class BookingDTO {
	
	private int idBooking;
	
	
	private int idEmployee;
	

	private int idCustomer;
	

	private Date bookingCreationDate;
	
	
	private Date bookingAtentionDate;
	
	
	public BookingDTO() {}


	
	
	public int getIdBooking() {
		return idBooking;
	}


	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}


	public int getIdEmployee() {
		return idEmployee;
	}


	public void setIdEmployee(int employee) {
		this.idEmployee = employee;
	}


	public int getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(int customer) {
		this.idCustomer = customer;
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
