package cn.tedu.ems.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;

/**
 * 
 *	业务层实现类
 */

@Service("loginService")
public class LoginServiceImpl implements 
	LoginService{
	
	@Resource(name="userDAO")
	private UserDAO userDAO;

	public User checkLogin(
			String username, String pwd) {
		User user = null;
		user = userDAO.findByUsername(username);
		
		if(user == null){
			//用户名不存在,抛一个应用异常
			//(由于用户不正确的操作引起的异常)
			throw new ApplicationException(
					"用户名不存在");
		}
		
		if(!user.getPwd().equals(pwd)){
			//密码错误，抛一个应用异常
			throw new ApplicationException("密码错误");
		}
		
		//登录验证通过，返回一个完整的User对象
		return user;
	}
	
}



