package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@RestController
@RequestMapping("submission")
public class SubmissionEndpoint {

	@Autowired
	private SubmissionServiceInterface submissionService;

	@Autowired
	private SubmissionMapper submissionMapper;

	@PostMapping
	public SubmissionDTO create(@RequestBody Submission Submission) {
		return submissionMapper.map(this.submissionService.save(Submission));
	}

	@PutMapping
	public SubmissionDTO update(@RequestBody Submission Submission) {
		return submissionMapper.map(this.submissionService.save(Submission));
	}

	@DeleteMapping("/{challengeId}/{userId}")
	public void delete(@PathVariable("challengeId") Long challengeId, @PathVariable("userId") Long userId) {
		this.submissionService.delete(challengeId, userId);
	}
	
	@GetMapping
	public List<SubmissionDTO> findAll() {
		return submissionMapper.map(this.submissionService.findAll());
	}
	
	
	
	@GetMapping("/challenge/{challengeId}/user/{userId}")
	public SubmissionDTO findByChallengeIdAndUserId(@PathVariable("challengeId") Long challengeId, @PathVariable("userId") Long userId) {
		return submissionMapper.map(this.submissionService.findByChallengeIdAndUserId(challengeId, userId));
	}

	@GetMapping("/challenge/{challengeId}/acceleration/{accelerationId}")
	List<SubmissionDTO> findByChallengeIdAndAccelerationId(@PathVariable("challengeId") Long challengeId, @PathVariable("accelerationId") Long accelerationId) {
		return submissionMapper
				.map(this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
	}

}
