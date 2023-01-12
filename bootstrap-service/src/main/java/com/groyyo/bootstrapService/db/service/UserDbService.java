package com.groyyo.bootstrapService.db.service;

import java.util.List;

import com.groyyo.bootstrapService.entity.UserEntity;
import com.groyyo.core.sqljpa.service.AbstractJpaService;

public interface UserDbService extends AbstractJpaService<UserEntity, Long> {

	/**
	 * @return
	 */
	List<UserEntity> getAllUsers();

	/**
	 * @param status
	 * @return
	 */
	List<UserEntity> getAllUsersForStatus(boolean status);

	/**
	 * @param id
	 * @return
	 */
	UserEntity getUserById(String id);

	/**
	 * @param userEntity
	 * @return
	 */
	UserEntity saveUser(UserEntity userEntity);

	/**
	 * @param userEntity
	 * @param status
	 * @return
	 */
	UserEntity activateDeactivateUser(UserEntity userEntity, boolean status);
}
