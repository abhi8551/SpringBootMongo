package com.storeData.modal;

import java.util.Date;
import java.util.List;

public class Bill {
	int billId;
	String customerName;
	Date date;
	int totalAmount;
	List<Product> productDetails;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Product> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<Product> productDetails) {
		this.productDetails = productDetails;
	}
}
