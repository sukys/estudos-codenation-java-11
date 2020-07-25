package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateServiceInterface extends ServiceInterface<Candidate, CandidateId> {

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);

	void delete(Long userId, Long companyId, Long accelerationId);
    
}
