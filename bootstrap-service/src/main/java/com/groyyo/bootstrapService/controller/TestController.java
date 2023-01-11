package com.groyyo.bootstrapService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groyyo.core.base.common.dto.ResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/test")
@Api
public class TestController {

	@GetMapping("")
	@ApiOperation("get")
	public ResponseDto<Void> test() {

		log.info("Testing bootstrap application");

		return ResponseDto.success("Done");
	}
}