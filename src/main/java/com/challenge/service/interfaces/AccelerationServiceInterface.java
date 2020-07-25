package com.challenge.service.interfaces;

import com.challenge.entity.Acceleration;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId, Pageable pageable);

}
