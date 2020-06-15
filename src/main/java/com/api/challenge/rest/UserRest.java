package com.api.challenge.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.challenge.dao.UserDao;
import com.api.challenge.entitys.User;

@RestController
@RequestMapping("/")
public class UserRest {

	@Autowired
	private UserDao userDAO;

	@GetMapping("getusers")
	public ResponseEntity<List<User>> getUser() {
		List<User> user = userDAO.findAll();
		return ResponseEntity.ok(user);
	}

	@PostMapping("createUsers")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		User newUser = userDAO.save(user);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("getusersById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {

		Optional<User> optionalUser = userDAO.findById(userId);
		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping("updateUsersById/{userId}") // modificar elemento en la base de datos
	public ResponseEntity<User> updateUsersById(@RequestBody User user) {

		Optional<User> optionalUser = userDAO.findById(user.getId());
		if (optionalUser.isPresent()) {
			User updateUser = optionalUser.get();
			updateUser.setName(user.getName());
			updateUser.setEmail(user.getEmail());
			updateUser.setBirthDate(user.getBirthDate());
			userDAO.save(updateUser);
			return ResponseEntity.ok(updateUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("deleteUsersById/{userId}") // borrar valor 
	public ResponseEntity<Void> deleteUsersById(@PathVariable Long userId) {
		userDAO.deleteById(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}


