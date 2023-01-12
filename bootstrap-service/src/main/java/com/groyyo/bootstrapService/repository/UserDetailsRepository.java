package com.groyyo.bootstrapService.repository;

import org.springframework.stereotype.Repository;

import com.groyyo.bootstrapService.entity.UserDetailsEntity;
import com.groyyo.core.mongobase.repository.AbstractMongoRepository;

@Repository
public interface UserDetailsRepository extends AbstractMongoRepository<UserDetailsEntity, String> {

}
