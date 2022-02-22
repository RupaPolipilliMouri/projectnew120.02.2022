package com.mouritech.onlinebookstoremanagement.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
	private long customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "cust_email_id", nullable = false)
	@Email(message = "Not a valid email")
	private String customerEmailId;
	@Column(name = "contact_no")
	private int customerContactNumber;
	@Column(name = "cust_address")
	private String address;
	
	public Customer() {
		
	}

	public Customer(String customerName, @Email(message = "Not a valid email") String customerEmailId,
			int customerContactNumber, String address) {
		super();
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerContactNumber = customerContactNumber;
		this.address = address;
	}

	public Customer(long customerId, String customerName,
			@Email(message = "Not a valid email") String customerEmailId, int customerContactNumber, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.customerContactNumber = customerContactNumber;
		this.address = address;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public int getCustomerContactNumber() {
		return customerContactNumber;
	}

	public void setCustomerContactNumber(int customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmailId="
				+ customerEmailId + ", customerContactNumber=" + customerContactNumber + ", address=" + address + "]";
	}
	
	

}