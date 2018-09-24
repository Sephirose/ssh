package cn.tedu.ems.util.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServiceI {

	// 使用@WebMethod注解标注WebServiceI接口中的方法
	@WebMethod
	String sayHello(String name);

	@WebMethod
	String save(String name, String pwd);

}
