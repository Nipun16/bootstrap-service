/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.service;

import com.groyyo.bootstrapService.dto.response.UserResponseDto;

/**
 * @author nipunaggarwal
 *
 */
public interface UserDetailsService {

	/**
	 * @param id
	 * @return
	 */
	UserResponseDto saveUserDetails(String id);

}
