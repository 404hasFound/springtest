package com.xk.dao.springdatajpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface BaseJpaDao<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>{
	/**
     * sql查询
     *
     * @param sql
     * @param args
     * @return
     */
   public  List myselfMaps(String sql, Object... args);
 
  /**
     * sql分页查询
     *
     * @param sql
     * @param args
     * @return
     */
   public  Page myselfMapPage(String sql, Pageable pageable, Object... args);
}
