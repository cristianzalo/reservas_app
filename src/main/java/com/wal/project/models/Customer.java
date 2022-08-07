package com.wal.project.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer  implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7898688583138722949L;

	@Id
    private int idCustomer;
    
    @Column(length = 50)
    private String customerName;
    
    @Column(length = 50)
    private String userCustomer;
    
    @Column(length = 50)
    private String password;
    
    @OneToMany( mappedBy = "customer")
    private List<Booking> bookings;
    
    
    public Customer() {}
    

    
    
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(String user) {
		this.userCustomer = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
    
    
    
    
    
    
    
    
}