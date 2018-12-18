package com.xk.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name="user_role")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class UserRole  implements GrantedAuthority{
	@Id
	private String id;
	@Column
	private String user_id;
	@Column
	private String role_id;
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="role_id",referencedColumnName="id",nullable=true,insertable=false,updatable=false)
	@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
	private Role role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getAuthority() {
		if(this.role == null){
			return "";
		}
		return this.role.getName();
	}
	
}
