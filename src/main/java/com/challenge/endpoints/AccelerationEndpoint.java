package com.challenge.endpoints;

import java.util.List;

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

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@RestController
@RequestMapping("acceleration")
public class AccelerationEndpoint {

	@Autowired
	private AccelerationServiceInterface accelerationService;

	@PostMapping
	public ResponseEntity<Acceleration> create(@Valid @RequestBody Acceleration acceleration) {
		try {
			acceleration = this.accelerationService.save(acceleration);
			return new ResponseEntity<>(acceleration, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<Acceleration> update(@Valid @RequestBody Acceleration acceleration) {
		try {
			acceleration = this.accelerationService.save(acceleration);
			return new ResponseEntity<>(acceleration, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Acceleration> delete(@PathVariable("id") Long id) {
		try {
			this.accelerationService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id) {
		try {
			Acceleration acceleration =  this.accelerationService.findById(id).get();
			return new ResponseEntity<>(acceleration, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Acceleration>> findByCompanyId(@RequestParam(value = "companyId", required = true) Long companyId) {
		try {
			List<Acceleration> accelerations =  this.accelerationService.findByCompanyId(companyId);
			return new ResponseEntity<>(accelerations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
