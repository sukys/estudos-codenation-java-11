package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByCandidatesIdAccelerationName(String name);

    List<User> findByCandidatesIdCompanyId(Long companyId);
    
}
