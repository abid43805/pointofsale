package com.pos.beans;




public class SaleDetail {

    public SaleDetail(Long sale, Long product, Double productPrice, Long quantity, Double subTotal) {
        this.sale = sale;
        this.product = product;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

  

	private Long saleDetailId;// sale_detail_id int(11) AI PK
	private Long sale;// sale_id int(11)

	private Long product; // product_id int(11)
	private Double productPrice; // product_price int(11)
	private Long quantity; // quantity int(11)
	private Double subTotal; // sub_total int(11)


	public Long getSaleDetailId() {
		return saleDetailId;
	}

	public void setSaleDetailId(Long saleDetailId) {
		this.saleDetailId = saleDetailId;
	}


	
	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
