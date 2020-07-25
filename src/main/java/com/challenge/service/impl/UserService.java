package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name, Pageable pageable) {
        return userRepository.findByCandidatesIdAccelerationName(name, pageable).getContent(); 
    }

    @Override
    public List<User> findByCompanyId(Long companyId, Pageable pageable) {
        return userRepository.findByCandidatesIdCompanyId(companyId, pageable).getContent();
    }

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable).getContent();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
