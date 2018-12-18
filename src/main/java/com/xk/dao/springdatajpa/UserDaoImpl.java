package com.xk.dao.springdatajpa;

import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.xk.entity.MyUser;

public class UserDaoImpl extends BaseJpaDaoImpl{
	@PersistenceContext
    private EntityManager em;
    @SuppressWarnings("unchecked")
    public Page<MyUser> myselfPageLeft(Pageable pageable) {
        String dataSql = "select t from MyUser t ";
        String countSql = "select count(t) from MyUser t where 1 = 1";
        
        javax.persistence.Query dataQuery = em.createQuery(dataSql);
        javax.persistence.Query countQuery = em.createQuery(countSql);
        
        long totalSize = (long) countQuery.getSingleResult();
        Page<MyUser> page = new PageImpl<MyUser>(dataQuery.getResultList(),pageable,totalSize);
        return page;
    }
    
    public List myselfMap(){
    	Session session = em.unwrap(Session.class);
    	String dataSql = "select * from user ";
    	SQLQuery q = session.createSQLQuery(dataSql);
    	q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	List list =q.list();
    	return list;
    }
    
    
    public Page pageMap(String name){
    	PageRequest pageable = new PageRequest(0, 2);
    	return super.myselfMapPage("select * from user where username=?", pageable, name);
    }
}
