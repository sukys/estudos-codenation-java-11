package com.challenge.endpoints;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@RestController
@RequestMapping("acceleration")
public class AccelerationEndpoint {

	@Autowired
	private AccelerationServiceInterface accelerationService;

	@PostMapping
	public Acceleration create(@RequestBody Acceleration acceleration) {
		return this.accelerationService.save(acceleration);
	}

	@PutMapping
	public Acceleration update(@RequestBody Acceleration acceleration) {
		return this.accelerationService.save(acceleration);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.accelerationService.delete(id);
	}

	@GetMapping
	public List<Acceleration> findAll() {
		return this.accelerationService.findAll();
	}

	@GetMapping("/{id}")
	public Acceleration findById(@PathVariable("id") Long id) {
		return this.accelerationService.findById(id).get();
	}

	@GetMapping("/company/{id}")
	public List<Acceleration> findByCompanyId(@PathParam("id") Long id) {
		return this.accelerationService.findByCompanyId(id);
	}
}
