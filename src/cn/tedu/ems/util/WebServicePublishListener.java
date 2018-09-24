package cn.tedu.ems.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

@WebListener
public class WebServicePublishListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// WebService的发布地址
		String address = "http://192.168.1.102:8989/WS_Server/WebService";
		// 发布WebService，WebServiceImpl类是WebServie接口的具体实现类
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("使用WebServicePublishListener发布webservice成功!");

	}

}
