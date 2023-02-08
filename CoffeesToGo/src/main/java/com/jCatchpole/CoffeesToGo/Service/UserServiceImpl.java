package com.jCatchpole.CoffeesToGo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.User;
import com.jCatchpole.CoffeesToGo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	//Save new user to the database
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	//Get a user from the database by its id value
	@Override
	public User getUserById(long id) {
		return userRepository.getReferenceById(id);
	}

	//Get a user from the database by its username value
	@Override
	public User getUserByUserName(String username) {
		return userRepository.getUserByUsername(username);
	}

	//Delete a user from the database by its id value
	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

	//Delete a user from the database by its username value
	@Override
	public void deleteUserByUsername(String username) {
		userRepository.deleteUserByUsername(username);
	}

	//Retrieve a list of all user held within the database
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
