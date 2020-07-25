package com.challenge.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {

    private SubmissionRepository repository;

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId, Pageable pageable) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId, pageable).getContent();
    }
    
	@Override
	public Submission save(Submission submission) {
		return repository.save(submission);
	}
	
	@Override
	public List<Submission> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}

	@Override
	public void delete(SubmissionId id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Long challengeId, Long userId) {
		Submission submission = repository.findByIdChallengeIdAndIdUserId(challengeId, userId).get();
		repository.delete(submission);
	}

	@Override
	public Submission findByChallengeIdAndUserId(Long challengeId, Long userId) {
		return repository.findByIdChallengeIdAndIdUserId(challengeId, userId).get();
		
	}
	
}
