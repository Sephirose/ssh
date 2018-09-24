package cn.tedu.ems.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL; 

public class HttpClient {
	public static void main(String[] args) {
		try {
	        String urlStr = "http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx";
	        URL url = new URL(urlStr);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setDoInput(true);
	        con.setDoOutput(true);
	        con.setRequestMethod("POST");
	        con.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	        OutputStream oStream = con.getOutputStream();
	        //下面这行代码是用字符串拼出要发送的xml，xml的内容是从测试软件里拷贝出来的
	        //需要注意的是，有些空格不要弄丢哦，要不然会报500错误的。
	        //参数什么的，你可以封装一下方法，自动生成对应的xml脚本
	        String soap = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
	        "<soap:Envelope "+
	        "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" "+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">"+ 
	          "<soap:Body>"+ 
	            "<qqCheckOnline xmlns=\"http://WebXml.com.cn/\">"+ 
	              "<qqCode>744287868</qqCode>"+ //你的qq号填到里边
	            "</qqCheckOnline> "+ 
	          "</soap:Body>"+ 
	        "</soap:Envelope>";
	        oStream.write(soap.getBytes());
	        oStream.close();

	        InputStream iStream = con.getInputStream();
	        Reader reader = new InputStreamReader(iStream);

	        int tempChar;
	        String str = new String();
	        while((tempChar = reader.read()) != -1){
	            str += (char) tempChar;
	        }
	        //下面这行输出返回的xml到控制台，相关的解析操作大家自己动手喽。
	        //如果想要简单的话，也可以用正则表达式取结果出来。
	        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>returnedxmlstr:"+str);
	        String result = str.substring(str.indexOf("<qqCheckOnlineResult>")+"<qqCheckOnlineResult>".length(), str.lastIndexOf("</qqCheckOnlineResult>"));    
	        System.out.println("result is "+result);
	        iStream.close();
	        oStream.close();
	        con.disconnect();
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
}
