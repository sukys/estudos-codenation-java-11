package com.challenge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByCandidatesIdAccelerationName(String name, Pageable pageable);

    Page<User> findByCandidatesIdCompanyId(Long companyId, Pageable pageable);
    
    Page<User> findAll(Pageable pageable);
}
