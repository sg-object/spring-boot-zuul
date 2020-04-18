package com.sg.zuul.config;

import java.lang.reflect.Constructor;
import javax.annotation.PostConstruct;
import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import com.netflix.zuul.filters.FilterRegistry;
import com.sg.zuul.SpringBootZuulApplication;
import com.sg.zuul.common.annotation.Filter;
import com.sg.zuul.common.enums.FilterType;
import com.sg.zuul.filter.AbstractFilter;

@Configuration
public class ZuulConfig {

	@PostConstruct
	public void initFilter() {
		String scanPath = SpringBootZuulApplication.class.getPackage().getName();
		FilterRegistry filterRegistry = FilterRegistry.instance();
		Reflections reflections = new Reflections(scanPath);
		reflections.getSubTypesOf(AbstractFilter.class).forEach(filter -> {
			Filter annotation = filter.getAnnotation(Filter.class);
			if (annotation != null) {
				try {

					Constructor<? extends AbstractFilter> constructor = filter
							.getConstructor(new Class[] { FilterType.class, boolean.class, int.class });

					AbstractFilter zuulFilter = (AbstractFilter) constructor.newInstance(annotation.filterType(),
							annotation.shouldFilter(), annotation.filterOrder());

					filterRegistry.put(filter.getTypeName(), zuulFilter);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
