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

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock 
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreateN() {
		final Long id = 1L;
		final String choice = "n";
		final Order created = new Order(id);
 
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getString()).thenReturn(choice);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, this.controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	} 
	
//	@Test
//	public void testCreateY() {
//		final Long id = 1L;
//		final String choice = "y";
//		final Order created = new Order(id);
// 
//		Mockito.when(utils.getLong()).thenReturn(id);
//		Mockito.when(utils.getString()).thenReturn(choice);
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		assertEquals(created, this.controller.create());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(utils, Mockito.times(1)).getString();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	} 
	
//	@Test
//	public void testReadAll() {
//		List<Item> items = new ArrayList<>();
//		items.add(new Item(1L, 1.99, "Sock"));
// 
//		Mockito.when(dao.readAll()).thenReturn(items);
//
//		assertEquals(items, controller.readAll());
//
//		Mockito.verify(dao, Mockito.times(1)).readAll();
//	}
////
//	@Test
//	public void testUpdate() {
//		Item updated = new Item(1L, 1.99, "Sock");
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getDouble()).thenReturn(updated.getProductPrice());
//		Mockito.when(this.utils.getString()).thenReturn(updated.getProductName());
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//		//Mockito.when(this.utils.getString()).thenReturn(updated.getFirstName(), updated.getSurname());
//
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.utils, Mockito.times(1)).getString();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}
//
//	@Test
//	public void testDelete() {
//		final long ID = 1L;
//
//		Mockito.when(utils.getLong()).thenReturn(ID);
//		Mockito.when(dao.delete(ID)).thenReturn(1);
//
//		assertEquals(1L, this.controller.delete());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).delete(ID);
//	}

}
