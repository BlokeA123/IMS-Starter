package com.qa.ims.persistence.domain;

public class OrderItems {

	Long productID;
	Long orderID;
	Double quantity;
	Double productPrice;
	Long id;
	String first_Name;
	String surname;
	String productName;

	public OrderItems(Long productID, Long orderID, Double quantity) {
		super();
		this.productID = productID;
		this.orderID = orderID;
		this.quantity = quantity;
	}
	
	

	

	public OrderItems(Double productPrice) {
		super();
		this.productPrice = productPrice;
	}





	public OrderItems(Long productID, Long orderID, Double quantity, Double productPrice, Long id,
			String first_Name, String surname, String productName) {
		super();
		this.productID = productID;
		this.orderID = orderID;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.id = id;
		this.first_Name = first_Name;
		this.surname = surname;
		this.productName = productName;
	}



	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [productID=" + productID + ", orderID=" + orderID + ", quantity=" + quantity + ", productPrice="
				+ productPrice + ", id=" + id + ", first_Name=" + first_Name + ", surname=" + surname + ", productName="
				+ productName + "]";
	}
	
	public String toStringTotalCost() {
		return "Order total cost = ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((productID == null) ? 0 : productID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		OrderItems other = (OrderItems) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
