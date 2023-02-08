package com.jCatchpole.CoffeesToGo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jCatchpole.CoffeesToGo.Model.Coffee;


public interface CoffeeRepository  extends JpaRepository<Coffee, Long>{
	//get coffee by name attribute
	Coffee getCoffeeByName(String name);
	//delete coffee by name attribute
	boolean deleteCoffeeByName(String name);
}
