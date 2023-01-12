/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.db.service;

import com.groyyo.bootstrapService.entity.UserDetailsEntity;
import com.groyyo.core.mongobase.service.AbstractMongoService;

/**
 * @author nipunaggarwal
 *
 */
public interface UserDetailsDbService extends AbstractMongoService<UserDetailsEntity, String> {

	/**
	 * @param id
	 * @return
	 */
	UserDetailsEntity getUserDetailsById(String id);

}
