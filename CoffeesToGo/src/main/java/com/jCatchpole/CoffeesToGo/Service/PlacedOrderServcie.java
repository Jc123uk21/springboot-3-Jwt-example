package com.jCatchpole.CoffeesToGo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.PlacedOrder;


@Service
public interface PlacedOrderServcie {
	public PlacedOrder addOrder(PlacedOrder order);
	public PlacedOrder getOrderById(long id);
	public void deleteOrderById(long id);
	public List<PlacedOrder> getAllOrders();
	public List<PlacedOrder> getAllUsersOrders(String username);
	public LocalDateTime getWaitingTime(String storeName);
}
