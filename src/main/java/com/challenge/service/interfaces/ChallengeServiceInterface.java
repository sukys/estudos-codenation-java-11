package com.challenge.service.interfaces;

import com.challenge.entity.Challenge;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ChallengeServiceInterface extends ServiceInterface<Challenge, Long> {

    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId, Pageable pageable);

}
