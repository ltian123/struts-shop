package service.impl;

import dao.IUserDao;
import entity.User;
import exception.UserExistException;
import factory.ObjectFactory;
import service.IUserService;

public class UserServiceImpl implements IUserService{

	private IUserDao userDao = (IUserDao) ObjectFactory.getObject("userDao");
	
	public void register(User user) throws UserExistException {
		//判断用户是否存在
		User u = userDao.selectUserByUsername(user.getUsername());
		//若存在
		if(u!=null){
			//抛出异常
			throw new UserExistException("该用户已经存在");
		}
		//若不存在,执行保存操作
		userDao.insertUser(user);
	}

	public User login(String username, String password) throws UserExistException {
		User user = userDao.selectUserByUsernameAndPassword(username, password);
		if(user != null){
			return user;
		}
		throw new UserExistException("用户名或密码错误,请重新登录");
	}

}
