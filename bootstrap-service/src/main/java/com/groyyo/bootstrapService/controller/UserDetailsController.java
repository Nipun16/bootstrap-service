/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groyyo.bootstrapService.dto.response.UserResponseDto;
import com.groyyo.bootstrapService.service.UserDetailsService;
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
@RequestMapping("/userDetails")
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("save/{id}")
	@ApiOperation("save")
	public ResponseDto<UserResponseDto> saveUserDetails(@PathVariable String id) {

		log.info("Request received to save userDetails");

		UserResponseDto userResponseDto = userDetailsService.saveUserDetails(id);

		return Objects.isNull(userResponseDto) ? ResponseDto.failure("Unable to add user details !!") : ResponseDto.success("User details found !!", userResponseDto);
	}
}
