/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.repository;

import org.springframework.stereotype.Repository;

import com.groyyo.bootstrapService.entity.UserEntity;
import com.groyyo.core.sqljpa.repository.AbstractJpaRepository;

/**
 * @author nipunaggarwal
 *
 */
@Repository
public interface UserRepository extends AbstractJpaRepository<UserEntity, Long> {

}
