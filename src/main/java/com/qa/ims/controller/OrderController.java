package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils = new Utils();
	private OrderItemsDAO orderitemsDAO = new OrderItemsDAO();
	OrderItemsController ordContObj = new OrderItemsController(orderitemsDAO, utils);

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	} 

	@Override
	public List<Order> readAll() {
		//List<Order> orders = orderDAO.readAll();
		//for (Order order : orders) {
			//LOGGER.info(order);
		//}
		ordContObj.readAll();
		return null;
	}

	@Override
	public Order create() { 
		boolean addItem = true;
		LOGGER.info("Please enter a customer ID");
		Long id = utils.getLong();
		Order order = orderDAO.create(new Order(id));
		while (addItem) {
			LOGGER.info("Do you want to add an item? Y/N");
			String choice = utils.getString();
			if (choice.toLowerCase().equals("y")) {
				ordContObj.create(order.getOrderID());
			} else { 
				addItem = false;
			}
		}
	
		LOGGER.info("Order created");
		return order;
}



	@Override
	public Order update() {
		boolean updateItems = true;
		LOGGER.info("Please enter a customer ID");
		Long id = utils.getLong();
		LOGGER.info("Please enter an order ID"); 
		Long orderID = utils.getLong();
		Order order = orderDAO.update(new Order(orderID, id));
		while (updateItems) {
			LOGGER.info("Do you want to update items to your order? Y/N");
			String choice2 = utils.getString();
			if (choice2.toLowerCase().equals("y")) {
				ordContObj.update();
			} else {
				updateItems = false;
			} 			
			LOGGER.info("Order Updated");
		}
		return order;
	}

	@Override
	public int delete() {
		boolean deleteItems = true;
		LOGGER.info("Please enter your order ID.");
		Long orderID = utils.getLong();
		while(deleteItems) {
		LOGGER.info("Would you like to delete an item from an order or an entire order? ITEMS/ORDER");
		String choice3 = utils.getString();
			if(choice3.toLowerCase().equals("items")) {
				ordContObj.delete(orderID);
			}else {
				deleteItems = false;
			}
		LOGGER.info("Order deleted");
		//orderitemsDAO.delete(orderID);
		return orderDAO.delete(orderID);
	}
		return 0;
}
}
