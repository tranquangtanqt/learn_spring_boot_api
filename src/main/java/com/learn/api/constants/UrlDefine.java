package com.learn.api.constants;

public final class UrlDefine {
	public static final String API_V_1 = "/api/v1";
	
	public static final String API_V_1_USER = API_V_1 + "/user";
	
	public static final String DEMO_INFO = API_V_1_USER +  "/getalldemo";
	
	public static final String TODO_INFO = API_V_1_USER +  "/todo/getall";

	public static final String TODO_INFO_CREATE = API_V_1_USER +  "/todo/create";
	
	
	public static final String TODO_DETAIL_INFO = API_V_1_USER +  "/todo/detail/getall";
	
	public static final String TODO_DETAIL_CREATE = API_V_1_USER +  "/todo/detail/create";
}
