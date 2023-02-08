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

import com.jCatchpole.CoffeesToGo.Model.Store;
import com.jCatchpole.CoffeesToGo.Service.StoreService;


@RestController
@RequestMapping("/store")
public class StoreController {
	
	private StoreService storeService;
	
	
	//constructor
	public StoreController(StoreService storeService) {
		super();
		this.storeService = storeService;
	}

	@PostMapping("/add")
	public ResponseEntity<Store> addNewStore(@RequestBody Store store){
		try {
			Store newStore = store;
			this.storeService.addStore(store);
			return new ResponseEntity<>(newStore, HttpStatus.CREATED);
		}catch(Exception ex){
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Store not saved,"
					+ " make sure store does not already exist!", ex);
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Store> getStore(@RequestParam long id){
		try {
			Store newStore = storeService.getStoreById(id);
			return new ResponseEntity<>(newStore, HttpStatus.OK);
		}catch(Exception ex){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Store not found!", ex);
		}
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> deleteStore(@RequestParam long id){
		try {
			storeService.getStoreById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Store not found!", ex);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Store>> getAllStores(){
		try {
			List<Store> stores = this.storeService.getAllStores();
			return new ResponseEntity<>(stores, HttpStatus.OK);
		}catch(Exception ex){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Stores found!", ex);
		}
	}	

}
