package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;

@RestController
@RequestMapping("user")
public class UserEndpoint {

	@Autowired
	private UserServiceInterface userService;
	
	@PostMapping
	public User create(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.userService.delete(id);
	}
	
	@GetMapping
	public List<User> findAll() {
		return this.userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return this.userService.findById(id).get();
	}

	@GetMapping("/acceleration/{name}")
    List<User> findByAccelerationName(@PathVariable("name") String name){
    	return this.userService.findByAccelerationName(name);
    }

	@GetMapping("/company/{id}")
	List<User> findByCompanyId(@PathVariable("id") Long id){
    	return this.userService.findByCompanyId(id);
    }
	
}
