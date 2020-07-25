package com.challenge.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChallengeService implements ChallengeServiceInterface {

	private ChallengeRepository repository;

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return repository.findByAccelerationIdAndUserId(accelerationId, userId);
	}

	@Override
	public Challenge save(Challenge challenge) {
		return repository.save(challenge);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Challenge> findAll() {
		return repository.findAll();
	}

}
