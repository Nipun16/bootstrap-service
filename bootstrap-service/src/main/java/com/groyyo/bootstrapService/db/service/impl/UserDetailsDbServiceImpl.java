/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.groyyo.bootstrapService.db.service.UserDetailsDbService;
import com.groyyo.bootstrapService.entity.UserDetailsEntity;
import com.groyyo.bootstrapService.repository.UserDetailsRepository;
import com.groyyo.core.mongobase.service.impl.AbstractMongoServiceImpl;

/**
 * @author nipunaggarwal
 *
 */
@Service
public class UserDetailsDbServiceImpl extends AbstractMongoServiceImpl<UserDetailsEntity, String, UserDetailsRepository> implements UserDetailsDbService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	protected UserDetailsRepository getMongoRepository() {
		return userDetailsRepository;
	}

	@Override
	protected MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public UserDetailsEntity getUserDetailsById(String id) {
		return mongoTemplate.findById(id, UserDetailsEntity.class);
	}
}
