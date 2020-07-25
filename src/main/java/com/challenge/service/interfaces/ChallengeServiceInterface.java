package com.challenge.service.interfaces;

import java.util.List;

import com.challenge.entity.Challenge;

public interface ChallengeServiceInterface extends ServiceInterface<Challenge, Long> {

    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
