package com.xk.dao.springdatajpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


public class BaseJpaDaoImpl {
    
    //实体管理类，对持久化实体做增删改查，自动义sq操作模板所需要的核心类
	@PersistenceContext
    private EntityManager entityManager;
 
 
    public List myselfMaps(String sql, Object... args) {
        //获取session
        Session session = (Session) entityManager.getDelegate();
        org.hibernate.Query q = session.createSQLQuery(sql);
         //查询结果转map        
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        int i = 0;
        for (Object arg : args
                ) {
            q.setParameter(i++, arg);
        }
        return q.list();
    }
 
    public Page myselfMapPage(String sql, Pageable pageable, Object... args) {
        Session session = (Session) entityManager.getDelegate();
        org.hibernate.Query q = session.createSQLQuery(sql);
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        int i = 0;
        for (Object arg : args
                ) {
            q.setParameter(i++, arg);
        }
 
        List<Map> totalCount = q.list();
        q.setFirstResult(pageable.getPageSize() * (pageable.getPageNumber() - 1));
        q.setMaxResults(pageable.getPageSize());
        List<Map> pageCount = q.list();
        Page<Map> pages = new PageImpl<>(pageCount, pageable, totalCount.size());
        return pages;
    }
}
