package com.challenge.service.impl;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChallengeService implements ChallengeServiceInterface {

    private ChallengeRepository repository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId, Pageable pageable) {
        return repository.findByAccelerationIdAndUserId(accelerationId, userId, pageable).getContent();
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
	public List<Challenge> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}

}
