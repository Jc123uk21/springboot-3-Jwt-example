package com.jCatchpole.CoffeesToGo.Model;

import java.util.ArrayList;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Coffee {
	
	//Attributes
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@NonNull
	private String name;
	@NonNull
	private double price;
	@NonNull
	private int kcals;
		
	private ArrayList<String> ingridients = new ArrayList<String>();
		
	@ManyToOne
	private PlacedOrder order;

	
	//Constructors
	public Coffee(String name, double price, int kcals, ArrayList<String> ingridients, PlacedOrder order) {
		super();
		this.name = name;
		this.price = price;
		this.kcals = kcals;
		this.ingridients = ingridients;
		this.order = order;
	}
	
	public Coffee() {}
	
	//Setter and Getter methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getKcals() {
		return kcals;
	}

	public void setKcals(int kcals) {
		this.kcals = kcals;
	}

	public ArrayList<String> getIngridients() {
		return ingridients;
	}

	public void setIngridients(ArrayList<String> ingridients) {
		this.ingridients = ingridients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

}
