package com.shop.utils;

import java.util.HashMap;
import java.util.Map;

public class AgricultureConstant {
	
	public static final String ATTR_NAME_MESSAGE = "MESSAGE";
	public static final String ATTR_NAME_LOGIN_USER= "LOGIN-USER";
	public static final String ATTR_NAME_ADMIN_USER= "ADMIN-USER";
	public static final String ATTR_NAME_PAGE_INFO = "PAGE-INFO";
	
	public static final String MESSAGE_LOGIN_FAILED = "登录账号或密码不正确！请核对后再登录！";
    public static final String TIPS_NO_FIND = "未发布生活小知识！";
    public static final String MESSAGE_NO_FIND = "未找到相关内容！";
    public static final String CLASS_NO_FIND = "未发布科普课堂！";
	public static final String MESSAGE_CODE_INVALID = "明文不是有效字符串，请核对后再操作！";
	public static final String MESSAGE_ACCESS_DENIED = "请登录后再操作！";
	public static final String MESSAGE_REGISTER_ACCT_ALREADY_IN_USE = "注册账号被占用，请重新设定！";
    public static final String MESSAGE_REGISTER_ACCT_SUCCESS = "注册成功！";
    public static final String MESSAGE_ASMIN_FALSE = "你不是管理员，无权进入后台";
	public static final Map<String, String> EXCEPTION_MESSAGE_MAP = new HashMap<String, String>();

	static {
		EXCEPTION_MESSAGE_MAP.put("java.lang.ArithmeticException", "系统在进行数学运算时发生错误");
		EXCEPTION_MESSAGE_MAP.put("java.lang.RuntimeException", "系统在运行时发生错误");
		EXCEPTION_MESSAGE_MAP.put("com.atguigu.agriculture.exception.LoginException", "登录过程中运行错误");
		EXCEPTION_MESSAGE_MAP.put("org.springframework.security.access.AccessDeniedException", "尊敬的用户，您现在不具备访问当前功能的权限！请联系超级管理员。");
	}

}
