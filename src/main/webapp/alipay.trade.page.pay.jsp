<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>付款</title>
</head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="com.alipay.api.*"%>
<%--<%@ page import="org.apache.commons.lang.*" %>--%>
<%@ page import="com.alipay.api.request.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.UUID" %>
<%
	//获得初始化的AlipayClient
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	
	//设置请求参数
	AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	alipayRequest.setReturnUrl(AlipayConfig.return_url);
//	alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
	alipayRequest.setNotifyUrl("http://34d538s283.qicp.vip/alipay.trade.page.pay.jsp");

	//商户订单号，商户网站订单系统中唯一订单号，必填
//	String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	String out_trade_no1 = "2021000116684393"+UUID.randomUUID().toString();
	String out_trade_no = new String(out_trade_no1.getBytes("ISO-8859-1"),"UTF-8");
	//付款金额，必填
//	String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
	String total_amount1 = "0.01";
	String total_amount = new String(total_amount1.getBytes("ISO-8859-1"),"UTF-8");
	//订单名称，必填
//	String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
	String subject1 = "Areio";
	String subject = new String(subject1.getBytes("ISO-8859-1"),"UTF-8");
	//商品描述，可空
//	String body1=UUID.randomUUID().toString();
//	String body = new String(body1.getBytes("ISO-8859-1"),"UTF-8");
	String body= new String(UUID.randomUUID().toString().getBytes("ISO-8859-1"),"UTF-8");


//+ "\"body\":\""+ body
	alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
			+ "\"total_amount\":\""+ total_amount +"\"," 
			+ "\"subject\":\""+ subject +"\","
			+ "\"body\":\""+ body +"\","
			+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
	
	//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
	//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
	//		+ "\"total_amount\":\""+ total_amount +"\"," 
	//		+ "\"subject\":\""+ subject +"\"," 
	//		+ "\"body\":\""+ body +"\"," 
	//		+ "\"timeout_express\":\"10m\"," 
	//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
	//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
	
	//请求
	String result = alipayClient.pageExecute(alipayRequest).getBody();
	
	//输出
	out.println(result);
%>
<body>
</body>
</html>