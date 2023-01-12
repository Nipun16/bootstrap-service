/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.groyyo.bootstrapService.dto.request.UserRequestDto;
import com.groyyo.bootstrapService.dto.response.UserResponseDto;
import com.groyyo.bootstrapService.entity.UserEntity;

import lombok.experimental.UtilityClass;

/**
 * @author nipunaggarwal
 *
 */
@UtilityClass
public class UserAdapter {

	public UserEntity buildUserEntityFromRequest(UserRequestDto userRequestDto) {

		return UserEntity
				.builder()
				.firstName(userRequestDto.getFirstName())
				.middleName(userRequestDto.getMiddleName())
				.lastName(userRequestDto.getLastName())
				.build();
	}

	public UserEntity cloneUserEntityWithRequest(UserRequestDto userRequestDto, UserEntity userEntity) {

		if (StringUtils.isNotBlank(userRequestDto.getFirstName()))
			userEntity.setFirstName(userRequestDto.getFirstName());
		if (StringUtils.isNotBlank(userRequestDto.getMiddleName()))
			userEntity.setMiddleName(userRequestDto.getMiddleName());
		if (StringUtils.isNotBlank(userRequestDto.getLastName()))
			userEntity.setLastName(userRequestDto.getLastName());

		return userEntity;
	}

	public UserResponseDto buildResponseFromEntity(UserEntity userEntity) {

		return UserResponseDto
				.builder()
				.uuid(userEntity.getUuid())
				.firstName(userEntity.getFirstName())
				.middleName(userEntity.getMiddleName())
				.lastName(userEntity.getLastName())
				.status(userEntity.isStatus())
				.build();
	}

	public List<UserResponseDto> buildResponsesFromEntities(List<UserEntity> userEntities) {

		return userEntities.stream().map(UserAdapter::buildResponseFromEntity).collect(Collectors.toList());
	}

}
