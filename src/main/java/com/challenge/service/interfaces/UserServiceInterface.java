package com.challenge.service.interfaces;

import com.challenge.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

public interface UserServiceInterface extends ServiceInterface<User, Long> {

    Optional<User> findById(Long userId);

    List<User> findByAccelerationName(String name, Pageable pageable);

    List<User> findByCompanyId(Long companyId, Pageable pageable);


}
