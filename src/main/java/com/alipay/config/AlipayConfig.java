package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102300746456";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDKZdvsYRpwKGDqtA23T2Df/Bo68S4U2xm6PPDSWKfuFrDqdW99y5Cjb4JXU2NO3iG4qskM18HLgAhIXKaDY9CGTV6BppsQpPH16ocn3OiHSqLVRc59li8LEOJJI6KgRz5k+jHbPORGMCbP5TsuLICS+EvlsV7oSDgVBWAChEiFU5hjqpkFgC8+wWRwvagg1kYoHs6TaaYBLQEe+NZaodMToJJbYfGZ6iZVz66oIAbURCEENlzu6mOJbqRXvHT2SIodk9BSUlAB3xstaR6t4yH0JKgFXWZdxd7job2gTKqkQn/MuAgSOTMOFNmFu1/CfOe5xayzH+aFrTeO1STI4uSVAgMBAAECggEAHSgZS28doOSgOY9gnnSn7vxhRvZxff2mMicPRi4RWwIX0F7EhemqV3D75NqVZsonL3Qi7F+0gj1adBosvqbFZmOE5sZ6diZc2OFFQR/Yu4yr8m9Q9NSKyFxRTNn+VnqM6X0Fa6DU/at4G+DY6qjsiL+OJ3OqyWmF8rlIgHRQAiyr7ecBkM95xVHTKCOfCJrk9yiE/YfSDZfQ9HhK/K3msc5kIyvvQsB4bjL7GB20tK4QvQAhwnHCoeSkCX3zu/fiCazazXL7dU2h3LdHxCICckybVWY8bRnV/9YFOBIC3ZoN7BoVqWUu15ujdnM0qXT3G+/d02xpSYMJYRb5FL76zQKBgQD21mCoZ1DfKh4IgLpU9ACnG1I5Z+UGa2p2BmfRPx36OxvGtYpZw1bqhqaPNsJElRCf0/Y//4GXuTcLz3+A3OTPITkEXA3eAhYCZhKv4VEWJkuAYwtI5yGB9WLjnktC+HhiuXu/QHvYBHoeUQjg4ArZfqRFbHJwFgPI6RuxmSkBFwKBgQDR6S+ZCfgI/RXiG3xPkAahkgF7RegmSPHKkPQrgREOTISGn3fO+RnN5A5FL3QGkXMUbOKEEWYASrETjYal5kJ1jeNPymZeoXl0CnjwKEFHlgP0FjmpUUT3jb1tMJWKSAFxUdGJO71LgX9QuEWfbsCtDPrnzAbKMunqngOUcB/bMwKBgDVlYJltaBgugzqxph00f2OmzF2wtOFzoR8Q+apRLgnweWy93sTWNdob8LHwVYwCdwssDgwAGKeaoGbEpz9YCYMpG61uwG0zJFG2hPpZEnJpLFIEmu9VWHFFhPPaTUuadmhc2YEg0OmE5mnie7oxnQc5lw2RjRvkF0OB8cS0biNXAoGAH0EXIzRGyB/WyEnLYpVRR3FT4yTvgfPOfJjEok2fWn+uI9VOo3SXkP5p2YdNQUUa22my+HMWuuhkIUMrTzxPnO05cUHzqBdm3A5LH4b+4UfG4usEPt+o4yspjz5ypZo/DL5f8o0AjGOFr2EgjLKS4bFTEnxgbm7SQWqxocJoG90CgYEA1YktRAyKsBuEP9lhTnqLLk6dUrtCob6UcwP7rvN4vHNqrUcR/6YQJEIas8mei/G2Boo/+hrdqDNTAL3l3qgTtfpj60KMyuUXFqepO7g2VIA20tYYxEhLXu6oBwy3D885yRcjetnx46x17h9iaOIUj3IJD5roFKz9TAatUYmw0SE=";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://34d538s283.qicp.vip/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://34d538s283.qicp.vip/paysuccess.html";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

