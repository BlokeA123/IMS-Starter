package com.qa.ims.persistence.domain;

public class Order {
	
	Long orderID;
	Long id;
	
	


	public Order(Long id) {
		super();
		this.id = id;
	}


	


	public Order(Long orderID, Long id) {
		super();
		this.orderID = orderID;
		this.id = id;
	}





	public Long getOrderID() {
		return orderID;
	}


	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + orderID + "  Customer ID: " + id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}


	

	
	

	
	
}
