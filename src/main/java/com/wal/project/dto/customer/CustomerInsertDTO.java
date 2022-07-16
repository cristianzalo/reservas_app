package com.wal.project.dto.customer;

public class CustomerInsertDTO {
	
	private int idCustomer;

	private String customerName;
	
	private String customerUser;
	
	private String customerPasword;
	
	
	public CustomerInsertDTO() {}


	
	
	
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


	public String getCustomerUser() {
		return customerUser;
	}


	public void setCustomerUser(String customerUser) {
		this.customerUser = customerUser;
	}


	public String getCustomerPasword() {
		return customerPasword;
	}


	public void setCustomerPasword(String customerPasword) {
		this.customerPasword = customerPasword;
	}
	
	
	
	
}
