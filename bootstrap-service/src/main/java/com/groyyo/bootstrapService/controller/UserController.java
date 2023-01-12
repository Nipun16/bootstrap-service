/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groyyo.bootstrapService.dto.request.UserRequestDto;
import com.groyyo.bootstrapService.dto.response.UserResponseDto;
import com.groyyo.bootstrapService.service.UserService;
import com.groyyo.core.base.common.dto.ResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * @author nipunaggarwal
 *
 */
@Api
@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("get/all")
	@ApiOperation("get")
	public ResponseDto<List<UserResponseDto>> getAllUsers(@RequestParam(value = "status", required = false) Boolean status) {

		log.info("Request received to get all users");

		List<UserResponseDto> userResponseDtos = userService.getAllUsers(status);

		return ResponseDto.success("Found " + userResponseDtos.size() + " users in the system", userResponseDtos);
	}

	@GetMapping("get/{id}")
	@ApiOperation("get")
	public ResponseDto<UserResponseDto> getUser(@PathVariable String id) {

		log.info("Request received to get user with id: {}", id);

		UserResponseDto userResponseDto = userService.getUserById(id);

		return Objects.isNull(userResponseDto) ? ResponseDto.failure("Found no user with id: " + id) : ResponseDto.success("Found user with id: " + id, userResponseDto);
	}

	@PostMapping("add")
	@ApiOperation("add")
	public ResponseDto<UserResponseDto> addUser(@RequestBody @Valid UserRequestDto userRequestDto) {

		log.info("Request received to add user: {}", userRequestDto);

		UserResponseDto userResponseDto = userService.addUser(userRequestDto);

		return Objects.isNull(userResponseDto) ? ResponseDto.failure("Unable to add user !!") : ResponseDto.success("User added successfully !!", userResponseDto);
	}

	@PostMapping("update")
	@ApiOperation("update")
	public ResponseDto<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto) {

		log.info("Request received to update user: {}", userRequestDto);

		UserResponseDto userResponseDto = userService.updateUser(userRequestDto);

		return Objects.isNull(userResponseDto) ? ResponseDto.failure("Unable to update user !!") : ResponseDto.success("User updated successfully !!", userResponseDto);
	}

	@PutMapping("{id}/toggle/status/{status}")
	@ApiOperation("activate")
	public ResponseDto<UserResponseDto> activateDeactivateUser(@PathVariable String id, @PathVariable boolean status) {

		log.info("Request received to activate / deactivate user with id: {}", id);

		UserResponseDto userResponseDto = userService.activateDeactivateUser(id, status);

		return Objects.isNull(userResponseDto) ? ResponseDto.failure("Found no user with id: " + id) : ResponseDto.success("Activated / Deactivated user with id: " + id, userResponseDto);
	}
}
