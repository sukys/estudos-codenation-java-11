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

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping("company")
public class CompanyEndpoint {

	@Autowired
	private CompanyServiceInterface companyService;

	@PostMapping
	public Company create(@RequestBody Company company) {
		return this.companyService.save(company);
	}

	@PutMapping
	public Company update(@RequestBody Company company) {
		return this.companyService.save(company);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.companyService.delete(id);
	}

	@GetMapping
	public List<Company> findAll() {
		return this.companyService.findAll();
	}

	@GetMapping("/{id}")
	public Company findById(@PathVariable("id") Long id) {
		return this.companyService.findById(id).get();
	}

	@GetMapping("/acceleration/{id}")
	List<Company> findByAccelerationId(@PathVariable("id") Long id) {
		return this.companyService.findByAccelerationId(id);
	}

	@GetMapping("/user/{id}")
	List<Company> findByUserId(@PathVariable("id") Long id) {
		return this.companyService.findByUserId(id);
	}

}
