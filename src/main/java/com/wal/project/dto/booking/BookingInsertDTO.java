package com.wal.project.dto.booking;

import java.util.Date;



public class BookingInsertDTO {
	
	
	
	private int id_customer;
	
	private int id_employee;
	
	private Date bookingCreationDate;
	
	private Date bookingAtentionDate;
	
	
	
	public BookingInsertDTO() {}



	public int getId_customer() {
		return id_customer;
	}



	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}



	public int getId_employee() {
		return id_employee;
	}



	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
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
