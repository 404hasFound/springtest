package com.xk.dao.springdatajpa;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.xk.entity.MyUser;

public interface UserDao extends BaseJpaDao<MyUser, String>{
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public abstract MyUser findByUsername(String name);
	
	@Modifying
	@Query("update MyUser u set u.username=?2 where u.username=?1")
	abstract void updateUserByName(String name,String newname);
	
	public Page<MyUser> findByUsername(String name,Pageable pageable);
	
	public Page<MyUser> myselfPageLeft(Pageable pageable);
	
	public List myselfMap();
	
	public Page pageMap(String name);
}
