package com.pos.beans;




public class Products {

	private Long productId;
	private String productName;
	private Double price;
	private Double purchasePrice;
	private Double quantityAtHand;
	private Supplier supplierId;

	
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

	
	public Double getQuantityAtHand() {
		return quantityAtHand;
	}

	public void setQuantityAtHand(Double quantityAtHand) {
		this.quantityAtHand = quantityAtHand;
	}

	
	public Supplier getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Supplier supplierId) {
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
}
