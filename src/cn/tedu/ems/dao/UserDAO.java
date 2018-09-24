package cn.tedu.ems.dao;

import java.util.Map;

import cn.tedu.ems.entity.User;

/**
 * 持久层接口
 *
 */

public interface UserDAO {
	public User findByUsername(String username);
	public void killByProcedure(Map<String, Object> paramMap);
}
