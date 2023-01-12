/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.dto.request;

import javax.validation.constraints.NotBlank;

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
public class UserRequestDto {

	private String id;

	@NotBlank(message = "First name can't be blank")
	private String firstName;
	private String middleName;
	private String lastName;

}
