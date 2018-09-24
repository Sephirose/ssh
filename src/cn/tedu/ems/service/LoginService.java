package cn.tedu.ems.service;

import cn.tedu.ems.entity.User;

/**
 * 	业务层接口
 *
 */
public interface LoginService {
	public User checkLogin(
			String username,String pwd);
	
}




