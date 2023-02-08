package com.jCatchpole.CoffeesToGo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.Coffee;



@Service
public interface CoffeeService {
	public void addCoffee(Coffee coffee);
	public Coffee getCoffeeByName(String name);
	public Coffee getCoffeeById(long id);
	public List<Coffee> getAllCoffees();
	public void deleteCoffeeById(long id);
	public boolean deleteCoffeeByName(String name);
}
