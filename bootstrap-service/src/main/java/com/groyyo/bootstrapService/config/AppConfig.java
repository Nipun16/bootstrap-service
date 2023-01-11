package com.groyyo.bootstrapService.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.groyyo.core.base.localdate.Java8LocalDateStdDeserializer;
import com.groyyo.core.base.localdate.Java8LocalDateStdSerializer;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class AppConfig {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

		SimpleModule module = new SimpleModule();
		module.addSerializer(new Java8LocalDateStdSerializer());
		module.addDeserializer(LocalDate.class, new Java8LocalDateStdDeserializer());

		mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(module);
		mapper.registerModule(new JavaTimeModule());

		return mapper;
	}

	@Bean("s3Client")
	public AmazonS3 s3Client() {
		log.info("Creating bean for S3Client.");
		return AmazonS3ClientBuilder.defaultClient();

	}

}