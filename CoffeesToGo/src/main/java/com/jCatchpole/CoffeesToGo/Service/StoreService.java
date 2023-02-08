package com.jCatchpole.CoffeesToGo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.Store;



@Service
public interface StoreService {
	public Store addStore(Store store);
	public Store getStoreById(long id);
	public void deleteStoreById(long id);
	public List<Store> getAllStores();
}
