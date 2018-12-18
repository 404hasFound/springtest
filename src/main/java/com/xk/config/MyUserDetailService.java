package com.xk.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xk.dao.springdatajpa.UserDao;
import com.xk.entity.MyUser;
import com.xk.entity.UserRole;
import com.xk.service.UserService;
import com.xk.util.SessionUtil;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	
	@Autowired
	private UserDao userDao;
	
	
	
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		 MyUser user = userDao.findByUsername(name);
		 /*Set<UserRole> g = user.getUserRole();
		 for(GrantedAuthority gr:g){
			 System.out.println(gr.getAuthority());
		 }*/
		 if(user != null){
			 return new User(user.getUsername(), user.getPassword(), true, true, true,
					 true, user.getUserRole());
		 }else{
			 throw new UsernameNotFoundException("用户不存在！");
		 }
	}



}
