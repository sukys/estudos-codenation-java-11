package com.challenge.service.interfaces;

import java.util.List;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

public interface SubmissionServiceInterface extends ServiceInterface<Submission, SubmissionId> {

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
    
    void delete(Long challengeId, Long userId);

    Submission findByChallengeIdAndUserId(Long challengeId, Long userId);

}
