package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;

@RestController
@RequestMapping("user")
public class UserEndpoint {

	@Autowired
	private UserServiceInterface userService;

	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		user = this.userService.save(user);
		return new ResponseEntity<>(user,
				Optional.ofNullable(user).isPresent() ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping
	public ResponseEntity<User> update(@Valid @RequestBody User user) {
		try {
			user = this.userService.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			this.userService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		try {
			User user = this.userService.findById(id).get();
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/acceleration/{name}")
	public ResponseEntity<List<User>> findByAccelerationName(@PathVariable("name") String name) {
		try {
			List<User> users = this.userService.findByAccelerationName(name);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/company/{id}")
	public ResponseEntity<List<User>> findByCompanyId(@PathVariable("id") Long id) {
		try {
			List<User> users = this.userService.findByCompanyId(id);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * ESTE TIPO DE CÓDIGO NÃO É UMA BOA PRATICA. UM METODO DEVE TER UMA
	 * RESPONSABILIDADE. O IDEAL É FAZER UM METODO PARA CADA NECESSIDADE
	 * 
	 * @param name
	 * @param companyId
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<User>> findByAccelerationNameOrByCompanyId(
			@RequestParam(name = "accelerationName", required = false, defaultValue = "") String name,
			@RequestParam(name = "companyId", required = false) Long companyId) {
		List<User> list = new ArrayList<>();
		if (Objects.nonNull(name) && !name.trim().isEmpty()) {
			list.addAll(this.userService.findByAccelerationName(name));
		} else if (Objects.nonNull(companyId) && companyId > 0) {
			list.addAll(this.userService.findByCompanyId(companyId));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	

}
