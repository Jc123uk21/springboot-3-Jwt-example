package com.jCatchpole.CoffeesToGo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.Store;
import com.jCatchpole.CoffeesToGo.Repository.StoreRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

	private StoreRepository repository;
	
	//Save Store to database
	@Override
	public Store addStore(Store store) {
		// TODO Auto-generated method stub
		return this.repository.save(store);
	}

	//Get Store by its id value from the database
	@Override
	public Store getStoreById(long id) {
		// TODO Auto-generated method stub
		return this.repository.getReferenceById(id);
	}

	//Delete store from the database by its id value
	@Override
	public void deleteStoreById(long id) {
		this.repository.deleteById(id);
	}

	//Get a List of all Store items from the database
	@Override
	public List<Store> getAllStores() {
		return this.repository.findAll();
	}

}
