/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nipunaggarwal
 *
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private String uuid;
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean status;

}
