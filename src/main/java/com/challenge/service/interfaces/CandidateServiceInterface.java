package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateServiceInterface extends ServiceInterface<Candidate, CandidateId> {

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId, Pageable pageable);

    List<Candidate> findByAccelerationId(Long accelerationId, Pageable pageable);

	void delete(Long userId, Long companyId, Long accelerationId);
    
}
