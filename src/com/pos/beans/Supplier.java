package com.pos.beans;

import java.util.Objects;



public class Supplier {

	private Long supplierId;
	private String supplierName;
	private String supplierContactNo;
	private String supplierEmail;
	private String supplierAddress;

	
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	
	public String getSupplierContactNo() {
		return supplierContactNo;
	}

	public void setSupplierContactNo(String supplierContactNo) {
		this.supplierContactNo = supplierContactNo;
	}

	
	public String getSupplierEmail() {
		return supplierEmail;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.supplierId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supplier other = (Supplier) obj;
        if (!Objects.equals(this.supplierId, other.supplierId)) {
            return false;
        }
        return true;
    }

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	
	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
}
