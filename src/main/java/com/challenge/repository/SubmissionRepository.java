package com.challenge.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query(" select max(s.score) from Submission s " +
            " join s.id.challenge cha " +
            " where cha.id = :challengeId ")
    Optional<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(" select s from Submission s " +
            " join s.id.challenge cha " +
            " join cha.accelerations acc " +
            " where acc.id = :accelerationId and cha.id = :challengeId ")
    Page<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId, Pageable pageable);
    
    Optional<Submission> findByIdChallengeIdAndIdUserId(Long challengeId, Long userId);
    
    Page<Submission> findAll(Pageable pageable);
    
}
