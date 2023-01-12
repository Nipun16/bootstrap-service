/**
 * @author nipunaggarwal
 *
 */
package com.groyyo.bootstrapService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.groyyo.core.sqljpa.entity.AbstractJpaEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author nipunaggarwal
 *
 */
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity(name = "users")
public class UserEntity extends AbstractJpaEntity {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Column(name = "first_name", columnDefinition = "varchar(100)", nullable = false)
	private String firstName;

	@Column(name = "middle_name", columnDefinition = "varchar(100)")
	private String middleName;

	@Column(name = "last_name", columnDefinition = "varchar(100)")
	private String lastName;

}
