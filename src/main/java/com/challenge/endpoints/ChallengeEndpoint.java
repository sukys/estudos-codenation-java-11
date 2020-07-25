package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping("challenge")
public class ChallengeEndpoint {

	@Autowired
	private ChallengeServiceInterface challengeService;

	@PostMapping
	public Challenge create(@RequestBody Challenge challenge) {
		return this.challengeService.save(challenge);
	}

	@PutMapping
	public Challenge update(@RequestBody Challenge challenge) {
		return this.challengeService.save(challenge);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.challengeService.delete(id);
	}

	@GetMapping
	public List<Challenge> findAll(Pageable pageable) {
		return this.challengeService.findAll(pageable);
	}

	@GetMapping("/{accelecarionId}/{userId}")
	public List<Challenge> findByAccelerationIdAndUserId(@PathVariable("accelerationId") Long accelerationId,
			@PathVariable("userId") Long userId, Pageable pageable) {
		return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId, pageable);
	}
}
