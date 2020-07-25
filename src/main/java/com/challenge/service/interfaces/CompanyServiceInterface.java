package com.challenge.service.interfaces;

import com.challenge.entity.Company;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface CompanyServiceInterface extends ServiceInterface<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findByAccelerationId(Long accelerationId, Pageable pageable);

    List<Company> findByUserId(Long userId, Pageable pageable);

}
