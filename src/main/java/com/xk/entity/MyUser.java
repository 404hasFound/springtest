package com.xk.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Table(name="user")
@org.hibernate.annotations.Table(appliesTo = "user")
public class MyUser{

	@Id
	private String id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String status;
	@Column
	private String descn;
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
	@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
	private List<UserRole> userRole;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	
	public String roleToString(){
		StringBuffer rb = new StringBuffer();
		for(UserRole r:userRole){
			rb.append(r.getRole().getName()+",");
		}
		if(rb.length()>0)
		rb.deleteCharAt(rb.length()-1);
		return rb.toString();
	}
	
	@Override
	public String toString(){
		return username+"密码："+password;
	}
}
