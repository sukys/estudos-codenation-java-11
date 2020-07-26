package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping("company")
public class CompanyEndpoint {

	@Autowired
	private CompanyServiceInterface companyService;

	@PostMapping
	public ResponseEntity<Company> create(@Valid @RequestBody Company company) {
		try {
			company = this.companyService.save(company);
			return new ResponseEntity<>(company, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<Company> update(@Valid @RequestBody Company company) {
		try {
			company = this.companyService.save(company);
			return new ResponseEntity<>(company, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Company> delete(@PathVariable("id") Long id) {
		try {
			this.companyService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable("id") Long id) {
		try {
			Company company = this.companyService.findById(id).get();
			return new ResponseEntity<>(company, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/acceleration/{id}")
	ResponseEntity<List<Company>> findByAccelerationId(@PathVariable("id") Long id) {
		try {
			List<Company> companies = this.companyService.findByAccelerationId(id);
			return new ResponseEntity<>(companies, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/user/{id}")
	ResponseEntity<List<Company>> findByUserId(@PathVariable("id") Long id) {
		try {
			List<Company> companies =  this.companyService.findByUserId(id);
			return new ResponseEntity<>(companies, HttpStatus.OK);
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
	public ResponseEntity<List<Company>> findByAccelerationIdOrUserId(
			@RequestParam(name = "accelerationId", required = false, defaultValue = "") Long accelerationId,
			@RequestParam(name = "userId", required = false) Long userId) {
		List<Company> list = new ArrayList<>();
		if (Objects.nonNull(accelerationId) && accelerationId > 0) {
			list.addAll( this.companyService.findByAccelerationId(accelerationId) );
		} else if (Objects.nonNull(userId) && userId > 0) {
			list.addAll(this.companyService.findByUserId(userId));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
