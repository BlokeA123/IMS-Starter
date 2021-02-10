package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

public class OrderItemsController implements CrudController<OrderItems> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemsDAO orderitemsDAO;
	private ItemDAO itmsDAO = new ItemDAO();
	private Utils utils;
	ItemController itmCont = new ItemController(itmsDAO, utils);
	public OrderItemsController(OrderItemsDAO orderitemsDAO, Utils utils) {
		super();
		this.orderitemsDAO = orderitemsDAO;
		this.utils = utils;
	}

	@Override 
	public List<OrderItems> readAll() {
		List<OrderItems> orderitems = orderitemsDAO.readAll();
		for (OrderItems orderitem : orderitems) {
			LOGGER.info(orderitem);
		} 
		return orderitems;
	}

	public OrderItems create(Long orderID) {
		LOGGER.info("Please enter a product ID you wish to add");
		LOGGER.info("Here are the list of items you can add to your order");
		itmCont.readAll();
		Long productID = utils.getLong();
		LOGGER.info("Please enter a quantity you wish to have");
		Double quantity = utils.getDouble();
		OrderItems orderitem = orderitemsDAO.create(new OrderItems(productID ,orderID, quantity));
		LOGGER.info("Here is your total cost of your order : " + orderitemsDAO.calcOrderCost(orderID));
		LOGGER.info("Item/s Added.");

		return orderitem; 
	}
   
	@Override
	public OrderItems update() {
		LOGGER.info("What is your order ID?");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter the id of the product you want to add or delete");
		Long productID = utils.getLong();
		LOGGER.info("Please enter a new quantity");
		Double quantity = utils.getDouble();
		OrderItems orderitem = orderitemsDAO.update(new OrderItems(productID, orderID, quantity));
		LOGGER.info("Item Updated");
		return orderitem;
	}
 
	public int delete(Long orderID) {
		LOGGER.info("Enter the product ID of the product you would like to delete in your order?");
		Long productID = utils.getLong();
		return orderitemsDAO.delete(orderID, productID);
	} 
 
	@Override
	public OrderItems create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
}
