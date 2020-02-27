package com.example.config;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor implements HandlerInterceptor {
	private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterCompletion(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object obj, 
			Exception e) {
		try {
			Collection<? extends GrantedAuthority> sch = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)sch;
			for(SimpleGrantedAuthority sfa : authorities) {
				log.info("---->"+sfa.getAuthority());
			}
		} catch (Exception ex) {
			log.info("Current user is null");
		}
		log.info("goose: Request is complete");
	}

	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object obj, 
			ModelAndView model)
			throws Exception {
		log.info("goose: Handler execution is complete");
	}

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object obj) throws Exception {
		log.info("goose: Before Handler execution");
		return true;
	}

}
