package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAO implements Dao<OrderItems>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long productID = resultSet.getLong("product_ID");
		Long orderID = resultSet.getLong("order_ID");
		Double quantity = resultSet.getDouble("Quantity");
		return new OrderItems(productID, orderID, quantity);
	}
	
	public OrderItems modelFromResultSet1(ResultSet resultSet) throws SQLException {
		Long productID = resultSet.getLong("product_ID");
		Long orderID = resultSet.getLong("order_ID");
		Double quantity = resultSet.getDouble("quantity");
		Double productPrice = resultSet.getDouble("Product_Price");
		Long id = resultSet.getLong("customer_id");
		String first_Name = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		String productName = resultSet.getString("Product_name");
		return new OrderItems(productID, orderID, quantity, productPrice, id, first_Name, surname, productName);
	}
	
	public OrderItems modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Double productPrice = resultSet.getDouble("totalCost");
		return new OrderItems(productPrice);
	}
	
	
	
	@Override
	public List<OrderItems> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT c.id as customer_id, o.order_ID, c.first_name, c.surname, oi.product_ID, oi.quantity, i.Product_name, i.Product_price FROM orders o LEFT JOIN orderitems oi ON o.order_ID=oi.order_ID LEFT JOIN customers c ON c.id=o.id LEFT JOIN items i ON i.product_ID=oi.product_ID;\r\n"
						+ "");) {
			List<OrderItems> orderitems = new ArrayList<>();
			while (resultSet.next()) {
				orderitems.add(modelFromResultSet1(resultSet));
			}
			return orderitems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public OrderItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems ORDER BY order_ID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public OrderItems create(OrderItems orderitems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderitems(order_ID, product_ID, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderitems.getOrderID());
			statement.setLong(2, orderitems.getProductID());
			statement.setDouble(3, orderitems.getQuantity());
			
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	} 
	
	@Override
	public OrderItems update(OrderItems orderitems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE orderitems SET quantity = ? WHERE product_ID = ? and order_ID = ?");) {
			statement.setDouble(1, orderitems.getQuantity());
			statement.setLong(2, orderitems.getProductID());
			statement.setLong(3, orderitems.getOrderID());
			statement.executeUpdate();
			return read(orderitems.getProductID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	public int delete(Long orderID, Long productID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE oi FROM orderitems oi WHERE order_ID = ? and product_ID = ?");) {
			statement.setLong(1, orderID);
			statement.setLong(2, productID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


	@Override
	public OrderItems read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public List<OrderItems> calcOrderCost(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT sum(Product_price*quantity) AS totalCost FROM orders o LEFT JOIN orderitems oi ON o.order_ID=oi.order_ID LEFT JOIN customers c ON c.id=o.id LEFT JOIN items i ON i.product_ID=oi.product_ID WHERE o.order_ID = ? ORDER BY oi.Order_Items_ID;\r\n"
						+ "");) {
			statement.setLong(1, orderID);
			List<OrderItems> orderitems = new ArrayList<>();
			try(ResultSet resultSet = statement.executeQuery();){
				while(resultSet.next()) {
					orderitems.add(modelFromResultSet2(resultSet));
					
				}
				return orderitems;
			}
					
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
		
		
	}



	

