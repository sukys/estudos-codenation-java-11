package com.challenge.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    Page<Acceleration> findByCandidatesIdCompanyId(Long companyId, Pageable pageable);

    Page<Acceleration> findAll(Pageable pageable);
}
