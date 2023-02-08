package com.jCatchpole.CoffeesToGo.Repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jCatchpole.CoffeesToGo.Model.PlacedOrder;

public interface PlacedOrderRepository extends JpaRepository<PlacedOrder, Long> {

	@Query(value = "SELECT * FROM placedorder WHERE user.username =?", nativeQuery = true)
	List<PlacedOrder> findAllByOrderUserUserName(String username);
	
	@Query(value ="SELECT * FROM placedorder WHERE store =?1 AND DATE(orderdatetime) =?2", nativeQuery = true)
	List<PlacedOrder> findAllByStoreAndOrderDateTime(String storeName, LocalDateTime date);
}
