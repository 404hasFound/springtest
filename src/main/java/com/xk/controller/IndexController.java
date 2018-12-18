package com.xk.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xk.entity.MyUser;
import com.xk.entity.Role;
import com.xk.entity.UserRole;
import com.xk.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)  
    public String homePage(ModelMap model) {  
        model.addAttribute("greeting", "Hi, Welcome to mysite");  
        return "welcome";  
    }  
	@RequestMapping(value ="404.jsp", method = RequestMethod.GET)  
    public String S404(ModelMap model) {  
        model.addAttribute("greeting", "Hi, Welcome to mysite");  
        return "welcome";  
    }  
    @RequestMapping(value = "/admin", method = RequestMethod.GET)  
    public String adminPage(ModelMap model) {  
        model.addAttribute("user", getPrincipal());  
        return "admin";  
    }  
       
    @RequestMapping(value = "/db", method = RequestMethod.GET)  
    public String dbaPage(ModelMap model) {  
        model.addAttribute("user", getPrincipal());  
        return "dba";  
    }  
   
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)  
    public String accessDeniedPage(ModelMap model) {  
        model.addAttribute("user", getPrincipal());  
        return "accessDenied";  
    }  
   
    @RequestMapping(value = "/login", method = RequestMethod.GET)  
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {  
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
    	if (principal instanceof UserDetails) {  
        	try {
				response.sendRedirect("");
			} catch (IOException e) {
				e.printStackTrace();
			};
			return "welcome";
        }  
        return "login";  
    }  
   
   /* @RequestMapping(value="/logout", method = RequestMethod.GET)  
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
            new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
        return "redirect:/login?logout";  
    }  */
    
    
    @RequestMapping(value="/user.action", method = RequestMethod.GET) 
    @ResponseBody
    public Page<MyUser> getUser (HttpServletRequest request, HttpServletResponse response) {  
    	/*MyUser usere = null;
    	usere.getUsername();*/
        Page<MyUser> user = userService.getUserByName(null,"user"); 
        com.xk.util.Page<MyUser> myuser = new com.xk.util.Page<>();
		return  user;
    } 
    
    @RequestMapping(value="/usermap", method = RequestMethod.GET) 
    @ResponseBody
    public String getUserMap (HttpServletRequest request, HttpServletResponse response) {  
    	MyUser user = new MyUser();
    	user.setUsername("Uasername");
    	user.setPassword("passWord");
		return  userService.getUser("basketbal",user);
    } 
    
    @RequestMapping(value="/userhi", method = RequestMethod.GET) 
    @ResponseBody
    public MyUser userhi (HttpServletRequest request, HttpServletResponse response) {  
    	boolean cache = true;
    	try{cache =(StringUtils.isEmpty(request.getParameter("cache"))?true:request.getParameter("cache").equals("false")?false:true);}catch(Exception e){e.printStackTrace();};
		return  userService.getHiUser(cache);
    } 
    
    @RequestMapping(value="/userjpa", method = RequestMethod.GET) 
    @ResponseBody
    public MyUser userjpa (HttpServletRequest request, HttpServletResponse response) {  
    	boolean cache = true;
    	try{cache =(StringUtils.isEmpty(request.getParameter("cache"))?true:request.getParameter("cache").equals("false")?false:true);}catch(Exception e){e.printStackTrace();};
		return  userService.findByUsername();
    } 
    
    @RequestMapping(value="/usermy", method = RequestMethod.GET) 
    @ResponseBody
    public List usermy (HttpServletRequest request, HttpServletResponse response) {  
		return  userService.getMybUser();
    } 
    
    @RequestMapping(value="/userpagemap", method = RequestMethod.GET) 
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public Page getUserPageMap (HttpServletRequest request, HttpServletResponse response) {  
		return  userService.getPageMap();
    } 
    
    private String getPrincipal(){  
        String userName = null;  
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
   
        if (principal instanceof UserDetails) {  
            userName = ((UserDetails)principal).getUsername();  
        } else {  
            userName = principal.toString();  
        }  
        return userName;  
    }
    
}
