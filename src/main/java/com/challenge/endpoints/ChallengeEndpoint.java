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

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping("challenge")
public class ChallengeEndpoint {

	@Autowired
	private ChallengeServiceInterface challengeService;

	@PostMapping
	public ResponseEntity<Challenge> create(@Valid @RequestBody Challenge challenge) {
		try {
			challenge = this.challengeService.save(challenge);
			return new ResponseEntity<>(challenge, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<Challenge> update(@Valid @RequestBody Challenge challenge) {
		try {
			challenge = this.challengeService.save(challenge);
			return new ResponseEntity<>(challenge, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Challenge> delete(@PathVariable("id") Long id) {
		try {
			this.challengeService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(
			@RequestParam(value = "accelerationId", required = true) Long accelerationId,
			@RequestParam(value = "userId", required = true) Long userId) {
		try {
			List<Challenge> list = this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
