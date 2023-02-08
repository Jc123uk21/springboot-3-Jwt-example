package com.jCatchpole.CoffeesToGo.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class PlacedOrder {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	@OneToOne
	@NonNull
	private User user;
	
	@OneToMany(mappedBy= "order")
	private List<Coffee> ordered;
	
	@NonNull
	private LocalDateTime orderDateTime;
	
	private LocalDateTime collected;
	
	@NonNull
	private double orderTotalPrice;
	
	@OneToOne
	@NonNull
	private Store collectionStore;
	
	@NonNull
	private LocalDateTime estimatedCollectionTime;
	
	//setter method to set the orderTotalPrice to the value of all items in the ordered list
	public double getOrderListTotal() {
		double total = 0;
		for(Coffee c: ordered) {
			 total = total + c.getPrice();
		}
		
		return total;
	}

	//General setter and getter methods
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Coffee> getOrdered() {
		return ordered;
	}

	public void setOrdered(List<Coffee> ordered) {
		this.ordered = ordered;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public LocalDateTime getCollected() {
		return collected;
	}

	public void setCollected(LocalDateTime collected) {
		this.collected = collected;
	}

	public Store getCollectionStore() {
		return collectionStore;
	}

	public void setCollectionStore(Store collectionStore) {
		this.collectionStore = collectionStore;
	}

	public LocalDateTime getEstimatedCollectionTime() {
		return estimatedCollectionTime;
	}

	public void setEstimatedCollectionTime(LocalDateTime estimatedCollectionTime) {
		this.estimatedCollectionTime = estimatedCollectionTime;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	
	
	
}
