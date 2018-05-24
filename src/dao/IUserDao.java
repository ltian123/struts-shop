package dao;

import entity.User;

public interface IUserDao {

	/**
	 * 用户注册
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @param password
	 */
	public User selectUserByUsername(String username);
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectUserByUsernameAndPassword(String username, String password);
	
	
	
	
}
