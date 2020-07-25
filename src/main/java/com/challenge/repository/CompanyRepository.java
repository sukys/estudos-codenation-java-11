package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

	List<Company> findByCandidatesIdUserId(Long userId);

}
