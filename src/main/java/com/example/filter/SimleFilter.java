package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimleFilter extends ZuulFilter{

	private static Logger log=LoggerFactory.getLogger(SimleFilter.class);
	
	public String filterType(){
		return "pre";
	}
	
	public int filterOrder(){
		return 1;
	}
	
	public boolean shouldFilter(){
		return true;
	}
	
	public Object run(){
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		log.info(String.format("%s request to %s",request.getMethod(),request.getRequestURL().toString()));
		return null;
	}
}
