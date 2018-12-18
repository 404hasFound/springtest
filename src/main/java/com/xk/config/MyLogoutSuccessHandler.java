package com.xk.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

import com.xk.util.SessionUtil;

@Service
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override  
    public void onLogoutSuccess  
      (HttpServletRequest request, HttpServletResponse response, Authentication authentication)   
      throws IOException, ServletException {  
        SessionUtil.logout(request);
        redirectStrategy.sendRedirect(request, response, "/login?logout");
    }  
}
