package com.jCatchpole.CoffeesToGo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.Coffee;
import com.jCatchpole.CoffeesToGo.Repository.CoffeeRepository;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	private CoffeeRepository coffeeRepository;

	//Save coffee to database
	@Override
	public void addCoffee(Coffee coffee) {
		this.coffeeRepository.save(coffee);
	}
	
	// Get coffe from database by its name value
	@Override
	public Coffee getCoffeeByName(String name) {
		return this.coffeeRepository.getCoffeeByName(name);
	}

	//Get Coffee by its id value
	@Override
	public Coffee getCoffeeById(long id) {
		// TODO Auto-generated method stub
		return this.coffeeRepository.getReferenceById(id);
	}

	//Get a List of all coffees held within the database
	@Override
	public List<Coffee> getAllCoffees() {
		// TODO Auto-generated method stub
		return this.coffeeRepository.findAll();
	}

	//Delete a coffee from the database by its id value
	@Override
	public void deleteCoffeeById(long id) {
		this.coffeeRepository.deleteById(id);
	}

	@Override
	public boolean deleteCoffeeByName(String name) {
		// TODO Auto-generated method stub
		return this.deleteCoffeeByName(name);
	}

}
