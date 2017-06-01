package com.jeffrychristian.app.domain.user;


import com.jeffrychristian.app.common.types.RoleType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 11/9/2016.
 */

@Entity
@Table(name="mst_user_role")
public class UserRole implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_SEQ")
	@SequenceGenerator(name="USER_ROLE_SEQ", sequenceName="USER_ROLE_SEQ", allocationSize=1)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private RoleType role;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "userid", referencedColumnName = "id", unique = true)
//	private User userId;

	public UserRole() {
	}

	public UserRole(RoleType role) {
		this.role = role;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
