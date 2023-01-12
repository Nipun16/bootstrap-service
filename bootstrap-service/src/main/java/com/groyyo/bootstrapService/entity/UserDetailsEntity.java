/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.entity;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.groyyo.core.mongobase.entity.AbstractMongoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author nipunaggarwal
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document("user_details")
@TypeAlias("user_details")
public class UserDetailsEntity extends AbstractMongoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Indexed(unique = true)
	private String userId;
	private String firstName;
	private String middleName;
	private String lastName;

}
