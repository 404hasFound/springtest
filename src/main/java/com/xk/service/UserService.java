package com.xk.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xk.dao.hibernate.PlatformDaoImpl;
import com.xk.dao.mybatis.UserDaoMybatis;
import com.xk.dao.springdatajpa.UserDao;
import com.xk.entity.MyUser;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PlatformDaoImpl platformDaoImpl;
	
	@Resource
	private UserDaoMybatis userDaoMybatis;
	
	public Page<MyUser> getUserByName(PageRequest pageRequest,String name){
		//userDao.updateUserByName("user", "user");
		PageRequest pageable = new PageRequest(0, 2);
		Order order1 = new Order(Direction.DESC, "status");
        Order order2 = new Order(Direction.ASC, "username");
        Sort sort = new Sort(order1, order2);
		//user = userDao.findpageByUsername(pageRequest,name);
        //return userDao.findAll(pageable);
		//return userDao.findByUsername("user", pageable);
        Page<MyUser> userp = userDao.myselfPageLeft(pageable);
        return userp;
	}
	
	public List<Map> getUserMap(){
        return userDao.myselfMap();
	}
	
	public MyUser findByUsername(){
		userDao.findByUsername("user");
		userDao.findByUsername("user");
		return userDao.findByUsername("user");
	}
	
	@Secured("ROLE_DBA")
	public Page getPageMap(){
        return userDao.pageMap("user");
	}
	
	public String getUser(String user,MyUser us){
		String a = null;
		a.equals("");
		return "哈哈哈";
	}
	
	@Cacheable(value="serviceca",condition="#cache")
	public MyUser getHiUser(boolean cache){
		MyUser myuser = platformDaoImpl.getUserById("2");
		return myuser;
	}
	
	public List<MyUser> getMybUser(){
		return userDaoMybatis.getAllUser();
	}
}
