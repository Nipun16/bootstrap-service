/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.groyyo.bootstrapService.adapter.UserAdapter;
import com.groyyo.bootstrapService.db.service.UserDbService;
import com.groyyo.bootstrapService.dto.request.UserRequestDto;
import com.groyyo.bootstrapService.dto.response.UserResponseDto;
import com.groyyo.bootstrapService.entity.UserEntity;
import com.groyyo.bootstrapService.service.UserService;
import com.groyyo.core.kafka.producer.NotificationProducer;

import lombok.extern.log4j.Log4j2;

/**
 * @author nipunaggarwal
 *
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

	@Value("${kafka.base.topic}")
	private String kafkaBaseTopic;

	@Autowired
	private NotificationProducer notificationProducer;

	@Autowired
	private UserDbService userDbService;

	@Override
	public List<UserResponseDto> getAllUsers(Boolean status) {

		log.info("Serving request to get all users");

		List<UserEntity> userEntities = Objects.isNull(status) ? userDbService.getAllUsers() : userDbService.getAllUsersForStatus(status);

		if (CollectionUtils.isEmpty(userEntities)) {
			log.error("No Users found in the system");
			return new ArrayList<UserResponseDto>();
		}

		return UserAdapter.buildResponsesFromEntities(userEntities);
	}

	@Override
	public UserResponseDto getUserById(String id) {

		log.info("Serving request to get a user by id:{}", id);

		UserEntity userEntity = userDbService.getUserById(id);

		if (Objects.isNull(userEntity)) {
			log.error("User with id: {} not found in the system", id);
			return null;
		}

		return UserAdapter.buildResponseFromEntity(userEntity);
	}

	@Override
	public UserResponseDto addUser(UserRequestDto userRequestDto) {

		log.info("Serving request to add a user with request object:{}", userRequestDto);

		UserEntity userEntity = UserAdapter.buildUserEntityFromRequest(userRequestDto);

		userEntity = userDbService.saveUser(userEntity);

		if (Objects.isNull(userEntity)) {
			log.error("Unable to add user for object: {}", userRequestDto);
			return null;
		}

		UserResponseDto userResponseDto = UserAdapter.buildResponseFromEntity(userEntity);

		notificationProducer.publish(kafkaBaseTopic, UserResponseDto.class.getName(), userEntity);

		return userResponseDto;
	}

	@Override
	public UserResponseDto updateUser(UserRequestDto userRequestDto) {

		log.info("Serving request to update a user with request object:{}", userRequestDto);

		UserEntity userEntity = userDbService.getUserById(userRequestDto.getId());

		if (Objects.isNull(userEntity)) {
			log.error("User with id: {} not found in the system", userRequestDto.getId());
			return null;
		}

		userEntity = UserAdapter.cloneUserEntityWithRequest(userRequestDto, userEntity);

		userDbService.saveUser(userEntity);

		return UserAdapter.buildResponseFromEntity(userEntity);
	}

	@Override
	public UserResponseDto activateDeactivateUser(String id, boolean status) {

		log.info("Serving request to activate / deactivate a user with id:{}", id);

		UserEntity userEntity = userDbService.getUserById(id);

		if (Objects.isNull(userEntity)) {
			log.error("User with id: {} not found in the system", id);
			return null;
		}

		userEntity = userDbService.activateDeactivateUser(userEntity, status);

		return UserAdapter.buildResponseFromEntity(userEntity);
	}

}
