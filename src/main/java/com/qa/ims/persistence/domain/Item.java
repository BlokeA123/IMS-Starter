package com.qa.ims.persistence.domain;

public class Item {

	Long productID;
	Double productPrice;
	String productName;

	public Item(String productName, double productPrice) {
		this.setProductName(productName);
		this.setProductPrice(productPrice);
	}

	public Item(Long productID, double productPrice, String productName) {
		this.setProductID(productID);
		this.setProductPrice(productPrice);
		this.setProductName(productName);
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "product ID: " + productID + "  Product Name: " + productName + "  Product price :" + productPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (getProductPrice() == null) {
			if (other.getProductPrice() != null)
				return false;
		} else if (!getProductPrice().equals(other.getProductPrice()))
			return false;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

}
