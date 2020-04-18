package com.sg.zuul.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FilterType {

	PRE_TYPE("pre") ,
	ROUTE_TYPE("route") ,
	POST_TYPE("post") ,
	ERROR_TYPE("error");
	
	@Getter
	private String value;
}
