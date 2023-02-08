package com.jCatchpole.CoffeesToGo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jCatchpole.CoffeesToGo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getUserByUsername(String username);
	
	void deleteUserByUsername(String username);
}
