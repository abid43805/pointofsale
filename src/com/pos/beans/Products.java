package com.pos.beans;

import java.util.Objects;




public class Products {

	private Long productId;
	private String productName;
	private Double price;
	private Double purchasePrice;
	private Long quantityAtHand;
	private String supplierId;
        private String barCode;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	public Long getQuantityAtHand() {
		return quantityAtHand;
	}

	public void setQuantityAtHand(Long quantityAtHand) {
		this.quantityAtHand = quantityAtHand;
	}

	
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
        @Override
        public String toString()
        {
            return this.productName;
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.productId);
        hash = 29 * hash + Objects.hashCode(this.productName);
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
        final Products other = (Products) obj;
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        return true;
    }
        
}
