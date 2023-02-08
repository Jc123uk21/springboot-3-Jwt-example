package com.jCatchpole.CoffeesToGo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jCatchpole.CoffeesToGo.Model.PlacedOrder;
import com.jCatchpole.CoffeesToGo.Service.PlacedOrderServcie;


@RestController
@RequestMapping("/placedorder")
public class PlacedOrderController {
	
	private PlacedOrderServcie orderService;
	
	//Store new order
	@PostMapping("/add")
	public ResponseEntity<PlacedOrder> addNewOrder(@RequestBody PlacedOrder order){
		try {
			PlacedOrder newOrder = order;
				this.orderService.addOrder(order);
				return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
			}catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Order not stored as it already exists!", ex);
			}
		}
		
	//Retrieve order by it's id
	@GetMapping("/{id}")
	public ResponseEntity<PlacedOrder> getOrderById(@RequestParam long id){
		try {
			  PlacedOrder order = this.orderService.getOrderById(id);
			  return new ResponseEntity<>(order, HttpStatus.OK);
				  
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found!", ex);
		}
	}
		
	//Delete order by it's id
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> deleteOrderById(@RequestParam long id){
		try {
			this.orderService.deleteOrderById(id);
			return new ResponseEntity<>(HttpStatus.OK);		
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order does not found!", ex);
		}
	}
		
	//Retrieve list of all orders
	@GetMapping("/all")
	public ResponseEntity<List<PlacedOrder>> getAllOrders(){
		try {
			List<PlacedOrder> orders = this.orderService.getAllOrders();
			return new ResponseEntity<>(orders, HttpStatus.OK);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "coffee list not found!", ex);
		}
	}
		
	//Retrieve list of users orders
	@GetMapping("/all/{username}")
	public ResponseEntity<List<PlacedOrder>> getUsersOrders(@RequestParam String username){
		try {
			List<PlacedOrder> userOrders = this.orderService.getAllUsersOrders(username);
			return new ResponseEntity<>(userOrders, HttpStatus.OK);	
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order List not found!", ex);
		}
	}
}
