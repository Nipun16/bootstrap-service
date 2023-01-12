/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groyyo.bootstrapService.db.service.UserDbService;
import com.groyyo.bootstrapService.entity.UserEntity;
import com.groyyo.bootstrapService.repository.UserRepository;
import com.groyyo.core.sqljpa.service.impl.AbstractJpaServiceImpl;

/**
 * @author nipunaggarwal
 *
 */
@Service
public class UserDbServiceImpl extends AbstractJpaServiceImpl<UserEntity, Long, UserRepository> implements UserDbService {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected UserRepository getJpaRepository() {
		return userRepository;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<UserEntity> getAllUsersForStatus(boolean status) {
		return userRepository.findByStatus(status);
	}

	@Override
	public UserEntity getUserById(String id) {
		return userRepository.findByUuid(id);
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.saveAndFlush(userEntity);
	}

	@Override
	public UserEntity activateDeactivateUser(UserEntity userEntity, boolean status) {
		userEntity.setStatus(status);
		return userRepository.saveAndFlush(userEntity);
	}
}
