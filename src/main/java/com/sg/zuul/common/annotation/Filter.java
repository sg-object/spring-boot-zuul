package com.sg.zuul.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.sg.zuul.common.enums.FilterType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Filter {

	FilterType filterType() default FilterType.PRE_TYPE;
	boolean shouldFilter() default true;
	int filterOrder() default 0;
}
