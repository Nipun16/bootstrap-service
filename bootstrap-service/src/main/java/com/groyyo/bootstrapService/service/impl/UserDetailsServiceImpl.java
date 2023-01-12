/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groyyo.bootstrapService.adapter.UserDetailsAdapter;
import com.groyyo.bootstrapService.db.service.UserDbService;
import com.groyyo.bootstrapService.db.service.UserDetailsDbService;
import com.groyyo.bootstrapService.dto.response.UserResponseDto;
import com.groyyo.bootstrapService.entity.UserDetailsEntity;
import com.groyyo.bootstrapService.entity.UserEntity;
import com.groyyo.bootstrapService.service.UserDetailsService;

import lombok.extern.log4j.Log4j2;

/**
 * @author nipunaggarwal
 *
 */
@Log4j2
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDbService userDbService;

	@Autowired
	private UserDetailsDbService userDetailsDbService;

	@Override
	public UserResponseDto saveUserDetails(String id) {
		UserDetailsEntity userDetailsEntity = null;
		UserResponseDto userResponseDto = null;

		UserEntity userEntity = userDbService.getUserById(id);

		if (Objects.isNull(userEntity)) {
			log.error("User with id: {} not found in the system", id);
			return userResponseDto;
		}

		userDetailsEntity = userDetailsDbService.getUserDetailsById(id);

		if (Objects.nonNull(userDetailsEntity)) {
			return UserDetailsAdapter.buildResponseFromUserDetails(userDetailsEntity);
		}

		userDetailsEntity = UserDetailsAdapter.buildUserDetailsFromUserEntity(userEntity);

		userDetailsDbService.save(userDetailsEntity);

		return UserDetailsAdapter.buildResponseFromUserDetails(userDetailsEntity);
	}

}
