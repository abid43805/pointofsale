package com.pos.beans;

import java.util.Date;




public class Sales {
	private Long saleId;
	private Customer customer; 				// customer_id int(11)
	private Date transactionDate; 			// transaction_date date
	private Long amountPaid; 				// amount_paid int(11)
	private int paidStatus; 				// paid_status tinyint(1)
	private User user; 						// user_id int(11)
	private Integer amountToBePaid;				//amount_to_be_paid(11)


	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	
	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}

	
	public int getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(int paidStatus) {
		this.paidStatus = paidStatus;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Integer getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(Integer amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

}
