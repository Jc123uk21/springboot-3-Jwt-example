package com.jCatchpole.CoffeesToGo.Authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jCatchpole.CoffeesToGo.Config.JwtService;
import com.jCatchpole.CoffeesToGo.Model.Role;
import com.jCatchpole.CoffeesToGo.Model.User;
import com.jCatchpole.CoffeesToGo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private UserRepository repository;
	
	private PasswordEncoder passwordEncoder;
	
	private JwtService jwtService;
	
	private AuthenticationManager authenticationManager;

	//Authentication response to registration
	public AuthenticationResponse register(RegisterRequest request) {
		//Create new user from request
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setContactNumber(request.getContactNumber());
		user.setRole(Role.USER);
		//Save new user to database
		repository.save(user);
		
		var jwtToken = jwtService.generateToken(user);
		
		AuthenticationResponse authResponse = new AuthenticationResponse();
		authResponse.setToken(jwtToken);
		return authResponse;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) throws UsernameNotFoundException{
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(),
						request.getPassword()));
		User user = repository.getUserByUsername(request.getUsername());
		
		var jwtToken = jwtService.generateToken(user);
		
		AuthenticationResponse authResponse = new AuthenticationResponse();
		authResponse.setToken(jwtToken);
		
		return null;
	}
	
}
