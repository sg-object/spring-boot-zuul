package com.sg.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.context.RequestContext;
import com.sg.zuul.common.annotation.Filter;
import com.sg.zuul.common.enums.FilterType;

@Filter
public class PreTestFilter extends AbstractFilter{

	private Logger logger = LoggerFactory.getLogger(PreTestFilter.class);
	
	public PreTestFilter(FilterType filterType, boolean shouldFilter, int filterOrder) {
		super(filterType, shouldFilter, filterOrder);
	}

	@Override
	public Object proccess() {
		// TODO Auto-generated method stub
		RequestContext context = getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.info("======================================================");
		logger.info(request.getRequestURL().toString());
		logger.info("Proccess Pre Filter");
		logger.info("======================================================");
		return null;
	}
	
}
