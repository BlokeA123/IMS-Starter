package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemsController;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;
@RunWith(MockitoJUnitRunner.class)
public class OrderItemsControllerTest {
	@Mock 
	private Utils utils;

	@Mock
	private OrderItemsDAO dao;

	@InjectMocks
	private OrderItemsController controller;
	
	@Test
	public void testCreate() {
		final Long productID = 1L;
		final Double quantity = 1D;
		final Long orderID = 2L;
		final OrderItems created = new OrderItems(productID, orderID, quantity);

		Mockito.when(utils.getLong()).thenReturn(productID);
		Mockito.when(utils.getDouble()).thenReturn(quantity);
		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	} 
	
	@Test
	public void testReadAll() {
		List<OrderItems> orderitems = new ArrayList<>();
		orderitems.add(new OrderItems(1L, 2L, 1D));
 
		Mockito.when(dao.readAll()).thenReturn(orderitems);

		assertEquals(orderitems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderItems updated = new OrderItems(1L, 2L, 1D);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getDouble()).thenReturn(1D);
		Mockito.when(this.utils.getLong()).thenReturn(2L);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long orderID = 1L;
		final long productID = 2L;

		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(utils.getLong()).thenReturn(productID);
		Mockito.when(dao.delete(orderID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());
 
		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(utils.getLong()).thenReturn(productID);
		Mockito.verify(dao, Mockito.times(1)).delete(orderID);
	}


}
