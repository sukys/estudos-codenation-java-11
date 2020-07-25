package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateService implements CandidateServiceInterface {

    private CandidateRepository candidateRepository;

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId, Pageable pageable) {
        return candidateRepository.findByIdCompanyId(companyId, pageable).getContent();
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId, Pageable pageable) {
        return candidateRepository.findByIdAccelerationId(accelerationId, pageable).getContent();
    }

	@Override
	public List<Candidate> findAll(Pageable pageable) {
		return candidateRepository.findAll(pageable).getContent();
	}

	@Override
	public void delete(Long userId, Long companyId, Long accelerationId) {
		Candidate candidate = candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId).get();
		candidateRepository.delete(candidate);
	}

	@Override
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public void delete(CandidateId id) {
		candidateRepository.deleteById(id);
	}

    
    
    
}
