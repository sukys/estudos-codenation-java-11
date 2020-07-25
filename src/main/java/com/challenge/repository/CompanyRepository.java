package com.challenge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Page<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId, Pageable pageable);

    Page<Company> findByCandidatesIdUserId(Long userId, Pageable pageable);

    Page<Company> findAll(Pageable pageable);
}
