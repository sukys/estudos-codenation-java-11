package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccelerationService implements AccelerationServiceInterface  {

    private AccelerationRepository accelerationRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId, Pageable pageable) {
        return accelerationRepository.findByCandidatesIdCompanyId(companyId, pageable).getContent();
    }

    @Override
    public Acceleration save(Acceleration entity) {
    	return accelerationRepository.save(entity); 
    }

	@Override
	public void delete(Long id) {
		accelerationRepository.deleteById(id);
	}

	@Override
	public List<Acceleration> findAll(Pageable pageable) {
		return accelerationRepository.findAll(pageable).getContent(); 
	}
    
}
