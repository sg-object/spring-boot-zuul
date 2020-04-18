package com.sg.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.context.RequestContext;
import com.sg.zuul.common.enums.FilterType;

public class TestFilter extends AbstractFilter{

	Logger logger = LoggerFactory.getLogger(TestFilter.class);
	
	public TestFilter(FilterType filterType, boolean shouldFilter, int filterOrder) {
		super(filterType, shouldFilter, filterOrder);
	}

	@Override
	public Object proccess() {
		// TODO Auto-generated method stub
		RequestContext ctx = getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(request.getRequestURL().toString());
		return null;
	}
	
}
