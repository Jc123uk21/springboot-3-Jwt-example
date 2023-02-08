package com.jCatchpole.CoffeesToGo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Model.User;



@Service
public interface UserService {
	public User addUser(User user);
	public User getUserById(long id);
	public User getUserByUserName(String username);
	public void deleteUserById(long id);
	public void deleteUserByUsername(String username);
	public List<User> getAllUsers();
}
