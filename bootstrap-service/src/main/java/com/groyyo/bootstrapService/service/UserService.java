/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.service;

import java.util.List;

import com.groyyo.bootstrapService.dto.request.UserRequestDto;
import com.groyyo.bootstrapService.dto.response.UserResponseDto;

/**
 * @author nipunaggarwal
 *
 */
public interface UserService {

	/**
	 * @param status
	 * @return
	 */
	List<UserResponseDto> getAllUsers(Boolean status);

	/**
	 * @param id
	 * @return
	 */
	UserResponseDto getUserById(String id);

	/**
	 * @param userRequestDto
	 * @return
	 */
	UserResponseDto addUser(UserRequestDto userRequestDto);

	/**
	 * @param userRequestDto
	 * @return
	 */
	UserResponseDto updateUser(UserRequestDto userRequestDto);

	/**
	 * @param id
	 * @param status
	 * @return
	 */
	UserResponseDto activateDeactivateUser(String id, boolean status);
}
