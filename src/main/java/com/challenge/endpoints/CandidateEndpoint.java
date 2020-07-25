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

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;

@RestController
@RequestMapping("candidate")
public class CandidateEndpoint {

	@Autowired
	private CandidateServiceInterface candidateService;

	@Autowired
	private CandidateMapper candidateMapper;

	@PostMapping
	public CandidateDTO create(@RequestBody Candidate Candidate) {
		return candidateMapper.map(this.candidateService.save(Candidate));
	}

	@PutMapping
	public CandidateDTO update(@RequestBody Candidate Candidate) {
		return candidateMapper.map(this.candidateService.save(Candidate));
	}

	@DeleteMapping("/{userId}/{companyId}/{accelerationId}")
	public void delete(@PathVariable("userId") Long userId, @PathVariable("companyId") Long companyId,
			@PathVariable("accelerationId") Long accelerationId) {
		this.candidateService.delete(userId, companyId, accelerationId);
	}

	@GetMapping
	public List<CandidateDTO> findAll() {
		return candidateMapper.map(this.candidateService.findAll());
	}

	@GetMapping("/{userId}/{companyId}/{accelerationId}")
	public CandidateDTO findById(@PathVariable("userId") Long userId, @PathVariable("companyId") Long companyId,
			@PathVariable("accelerationId") Long accelerationId) {
		return candidateMapper.map(this.candidateService.findById(userId, companyId, accelerationId).get());
	}

	@GetMapping("/company/{id}")
	public List<CandidateDTO> findByCompanyId(@PathVariable("id") Long id) {
		return candidateMapper.map(this.candidateService.findByCompanyId(id));
	}

	@GetMapping("/acceleration/{id}")
	public List<CandidateDTO> findByAccelerationId(@PathVariable("id") Long id) {
		return candidateMapper.map(this.candidateService.findByAccelerationId(id));
	}
}
