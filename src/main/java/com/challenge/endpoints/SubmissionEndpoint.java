package com.challenge.endpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<SubmissionDTO> create(@Valid @RequestBody Submission Submission) {
		try {
			SubmissionDTO dto = submissionMapper.map(this.submissionService.save(Submission));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<SubmissionDTO> update(@Valid @RequestBody Submission Submission) {
		try {
			SubmissionDTO dto = submissionMapper.map(this.submissionService.save(Submission));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{challengeId}/{userId}")
	public ResponseEntity<SubmissionDTO> delete(@PathVariable("challengeId") Long challengeId,
			@PathVariable("userId") Long userId) {
		try {
			this.submissionService.delete(challengeId, userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(
			@RequestParam(value = "challengeId", required = true) Long challengeId,
			@RequestParam(value = "accelerationId", required = true) Long accelerationId) {
		try {
			List<SubmissionDTO> dtos = submissionMapper
					.map(this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
