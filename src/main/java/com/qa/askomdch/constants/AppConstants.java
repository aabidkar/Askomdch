package com.qa.askomdch.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_LONG_TIME_OUT = 20;

	public static final String LOGIN_PAGE_TITLE_VALUE = "Account – AskOmDch";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "account";
	public static final Object ACCOUNT_PAGE_NAVIGATION_LIST_COUNT = 6;
	
	public static final String STORE_PAGE_TITLE_VALUE = "Products – AskOmDch";
	public static final String STORE_PAGE_URL_FRACTION_VALUE = "store";
	
	public static final List<String> EXPECTED_ACCOUNT_PAGE_NAVIGATION_LIST = Arrays.asList("Dashboard","Orders","Downloads","Addresses","Account details","Logout");
	//******************** Sheet Names ***********************//
	public static final String REGISTER_SHEET_NAME = "register";

}
