package com.jCatchpole.CoffeesToGo.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.jCatchpole.CoffeesToGo.Model.PlacedOrder;
import com.jCatchpole.CoffeesToGo.Repository.PlacedOrderRepository;

public class PlacedOrderImpl implements PlacedOrderServcie {
	
	private PlacedOrderRepository orderRepository;

	//Save an order to the database
	@Override
	public PlacedOrder addOrder(PlacedOrder order) {
		return orderRepository.save(order);
	}

	//retrieve an order from the database by its id value
	@Override
	public PlacedOrder getOrderById(long id) {
		return orderRepository.getReferenceById(id);
	}

	//Delete an order from the database by its id value
	@Override
	public void deleteOrderById(long id) {
		orderRepository.deleteById(id);
	}

	//Retrieve a list of all orders held within the database
	@Override
	public List<PlacedOrder> getAllOrders() {
		return orderRepository.findAll();
	}

	//Retrieve a list of orders made by a single user by their username
	@Override
	public List<PlacedOrder> getAllUsersOrders(String username) {
		// TODO Auto-generated method stub
		return orderRepository.findAllByOrderUserUserName(username);
	}

	//Retrieve the expected collection time at a given store
	@Override
	public LocalDateTime getWaitingTime(String storeName) {
		LocalDateTime orderedTime = LocalDateTime.now().minusMinutes(10);
		List<PlacedOrder> currentStoreOrders = orderRepository.findAllByStoreAndOrderDateTime(storeName,orderedTime);
		return LocalDateTime.now().plusMinutes(currentStoreOrders.size() * 4);
	}

}
