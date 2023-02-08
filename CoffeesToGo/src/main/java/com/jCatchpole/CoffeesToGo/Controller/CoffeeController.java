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

import com.jCatchpole.CoffeesToGo.Model.Coffee;
import com.jCatchpole.CoffeesToGo.Service.CoffeeService;


@RestController
@RequestMapping("/coffee")
public class CoffeeController {
	
	private CoffeeService coffeeService;

	//Add new Coffee to database
	@PostMapping("/add")
	public ResponseEntity<Coffee> saveCoffee(@RequestBody Coffee coffee){
	try{
		Coffee newCoffee = coffee;
		this.coffeeService.addCoffee(coffee);
		return new ResponseEntity<Coffee>(newCoffee, HttpStatus.CREATED);
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, 
				"Coffee not stored, check coffee does not already exist!", ex);
		}
	}
		
	//Get Coffee by it's name 
		@GetMapping("/{name}")
		public ResponseEntity<Coffee> getCoffeeByName(@RequestParam String name){
			try {
				Coffee coffee = coffeeService.getCoffeeByName(name);
				return new ResponseEntity<>(coffee, HttpStatus.OK);
		
				}catch(Exception ex) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee not found!",ex);
				}
		}
		
		//Get Coffee by it's id 
		@GetMapping("/{id}")
		public ResponseEntity<Coffee> getCoffeeByName(@RequestParam long id){
			try {
					Coffee coffee = coffeeService.getCoffeeById(id);
					return new ResponseEntity<>(coffee, HttpStatus.OK);
			
				}catch(Exception ex) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee not found!",ex);
				}
		}
		
		//Delete coffee by it's name
		@PostMapping("/delete/{name}")
		public ResponseEntity<?> deleteCoffeeByName(@RequestParam String name){
			try {
				  this.coffeeService.deleteCoffeeByName(name);
				  return new ResponseEntity<>(HttpStatus.OK);
			}catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee Not found!", ex);
			}
		}
		
		//Delete coffee by it's id
		@PostMapping("/delete/{id}")
		public ResponseEntity<?> deleteCoffeeByName(@RequestParam long id){
			try {
					this.coffeeService.deleteCoffeeById(id);
					return new ResponseEntity<>(HttpStatus.OK);
			}catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee Not found!", ex);
			}
		}
		
		//Get list of  all coffees
		@GetMapping("/all")
		public ResponseEntity<List<Coffee>> getAllCoffees(){
			try {
				List<Coffee> coffees = this.coffeeService.getAllCoffees();
				return new ResponseEntity<>(coffees, HttpStatus.OK);
			}catch(Exception ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No coffee list found", ex);
			}
		}	

}
