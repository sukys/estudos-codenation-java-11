package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Company;

public interface CompanyServiceInterface extends ServiceInterface<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findByAccelerationId(Long accelerationId);

    List<Company> findByUserId(Long userId);

}
