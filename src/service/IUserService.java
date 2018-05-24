package service;

import entity.User;
import exception.UserExistException;

public interface IUserService {

	/**
	 * 用户注册
	 * @param user
	 * @throws UserExistException 
	 */
	public void register(User user) throws UserExistException;
	
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws UserExistException 
	 */
	public User login(String username,String password) throws UserExistException;
}
