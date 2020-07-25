package com.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyServiceInterface {

    private CompanyRepository companyRepository;

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId, Pageable pageable) {
        return companyRepository.findDistinctByCandidatesIdAccelerationId(accelerationId, pageable).getContent();
    }

    @Override
    public List<Company> findByUserId(Long userId, Pageable pageable) {
        return companyRepository.findByCandidatesIdUserId(userId, pageable).getContent();
    }

	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public void delete(Long id) {
		companyRepository.deleteById(id);	
	}

	@Override
	public List<Company> findAll(Pageable pageable) {
		return companyRepository.findAll(pageable).getContent();
	}
    
    
}
