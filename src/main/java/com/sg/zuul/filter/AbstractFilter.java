package com.sg.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sg.zuul.common.enums.FilterType;

public abstract class AbstractFilter extends ZuulFilter{

	protected FilterType filterType;
	
	protected boolean shouldFilter;
	
	protected int filterOrder;
	
	public AbstractFilter(FilterType filterType, boolean shouldFilter, int filterOrder) {
		// TODO Auto-generated constructor stub
		this.filterType = filterType;
		this.shouldFilter = shouldFilter;
		this.filterOrder = filterOrder;
	}
	
	abstract public Object proccess();
	
	protected RequestContext getCurrentContext(){
		return RequestContext.getCurrentContext();
	}
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return shouldFilter;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		return proccess();
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return filterType.getValue();
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return filterOrder;
	}
	
}
