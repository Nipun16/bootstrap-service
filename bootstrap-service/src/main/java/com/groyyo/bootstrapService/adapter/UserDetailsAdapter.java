/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.adapter;

import com.groyyo.bootstrapService.dto.response.UserResponseDto;
import com.groyyo.bootstrapService.entity.UserDetailsEntity;
import com.groyyo.bootstrapService.entity.UserEntity;

import lombok.experimental.UtilityClass;

/**
 * @author nipunaggarwal
 *
 */
@UtilityClass
public class UserDetailsAdapter {

	public UserDetailsEntity buildUserDetailsFromUserEntity(UserEntity userEntity) {

		return UserDetailsEntity
				.builder()
				.firstName(userEntity.getFirstName())
				.middleName(userEntity.getMiddleName())
				.lastName(userEntity.getLastName())
				.build();
	}

	public UserResponseDto buildResponseFromUserDetails(UserDetailsEntity userDetailsEntity) {

		return UserResponseDto
				.builder()
				.uuid(userDetailsEntity.getUuid())
				.firstName(userDetailsEntity.getFirstName())
				.middleName(userDetailsEntity.getMiddleName())
				.lastName(userDetailsEntity.getLastName())
				.status(userDetailsEntity.isStatus())
				.build();
	}
}
