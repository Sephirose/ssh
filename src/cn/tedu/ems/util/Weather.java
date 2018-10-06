package cn.tedu.ems.util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

 
/**
 * 全国天气预报查询
 */
public class Weather {
	 
	
		
		public static void main(String[] args) {
		   System.out.println(getWeather("杭州市"));
		}
		
		public static String getWeather(String name) {
			String host = "http://jisutqybmf.market.alicloudapi.com";
		    String path = "/weather/query";
		    String method = "GET";
		    String appcode = "你的appcode";
		    Map<String, String> headers = new HashMap<String, String>();
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    querys.put("city", name);
		    try {
		    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
		    	HttpEntity httpEntity = response.getEntity();
		    	// 将HttpEntity中返回实体转化为输入流
		    	InputStream is = httpEntity.getContent();
		    	// 读取输入流，即返回文本内容
		    	BufferedReader br = new BufferedReader(new InputStreamReader(is));
		    	return br.readLine();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    	return "";
		    }
		}

}
