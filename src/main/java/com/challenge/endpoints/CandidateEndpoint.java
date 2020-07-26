package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
	public ResponseEntity<CandidateDTO> create(@Valid @RequestBody Candidate Candidate) {
		try {
			CandidateDTO dto = candidateMapper.map(this.candidateService.save(Candidate));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<CandidateDTO> update(@Valid @RequestBody Candidate Candidate) {
		try {
			CandidateDTO dto = candidateMapper.map(this.candidateService.save(Candidate));
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{userId}/{companyId}/{accelerationId}")
	public ResponseEntity<CandidateDTO> delete(@PathVariable("userId") Long userId,
			@PathVariable("companyId") Long companyId, @PathVariable("accelerationId") Long accelerationId) {
		try {
			this.candidateService.delete(userId, companyId, accelerationId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{userId}/{companyId}/{accelerationId}")
	public ResponseEntity<CandidateDTO> findById(
			@PathVariable("userId") Long userId,
			@PathVariable("companyId") Long companyId, 
			@PathVariable("accelerationId") Long accelerationId) {
		try {
			Optional<Candidate> optCandidate = this.candidateService.findById(userId, companyId, accelerationId);
			return optCandidate.isPresent()
					? new ResponseEntity<>(candidateMapper.map(optCandidate.get()), HttpStatus.OK)
					: new ResponseEntity<>(new CandidateDTO(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/company/{id}")
	public ResponseEntity<List<CandidateDTO>> findByCompanyId(@PathVariable("id") Long id) {
		try {
			List<CandidateDTO> list = candidateMapper.map(this.candidateService.findByCompanyId(id));
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/acceleration/{id}")
	public ResponseEntity<List<CandidateDTO>> findByAccelerationId(@PathVariable("id") Long id) {
		try {
			List<CandidateDTO> list = candidateMapper.map(this.candidateService.findByAccelerationId(id));
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * ESTE TIPO DE CÓDIGO NÃO É UMA BOA PRATICA. UM METODO DEVE TER UMA
	 * RESPONSABILIDADE. O IDEAL É FAZER UM METODO PARA CADA NECESSIDADE
	 * 
	 * @param name
	 * @param companyId
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<CandidateDTO>> findByCompanyIdOrAccelerationId(
			@RequestParam(name = "companyId", required = false) Long companyId,
			@RequestParam(name = "accelerationId", required = false, defaultValue = "") Long accelerationId) {
		List<Candidate> list = new ArrayList<>();
		if (Objects.nonNull(companyId) && companyId > 0) {
			list.addAll(this.candidateService.findByCompanyId(companyId));
		} else if (Objects.nonNull(accelerationId) && accelerationId > 0) {
			list.addAll(this.candidateService.findByAccelerationId(accelerationId));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(candidateMapper.map(list), HttpStatus.OK);
	}

}
