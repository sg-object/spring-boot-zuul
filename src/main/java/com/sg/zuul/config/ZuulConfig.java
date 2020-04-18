package com.sg.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sg.zuul.common.enums.FilterType;
import com.sg.zuul.filter.TestFilter;

@Configuration
public class ZuulConfig {

	@Bean
	public TestFilter testFilter() {
		return new TestFilter(FilterType.PRE_TYPE, true, 0);
	}
}
