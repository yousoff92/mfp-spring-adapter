package com.yousoff.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class JsonResponse {
	
	private String statusCode;
	private String statusDescription;
	private Object data;
	
}
