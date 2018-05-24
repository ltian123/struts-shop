package service.impl;

import dao.IUserDao;
import entity.User;
import exception.UserExistException;
import factory.ObjectFactory;
import service.IUserService;

public class UserServiceImpl implements IUserService{

	private IUserDao userDao = (IUserDao) ObjectFactory.getObject("userDao");
	
	public void register(User user) throws UserExistException {
		//�ж��û��Ƿ����
		User u = userDao.selectUserByUsername(user.getUsername());
		//������
		if(u!=null){
			//�׳��쳣
			throw new UserExistException("���û��Ѿ�����");
		}
		//��������,ִ�б������
		userDao.insertUser(user);
	}

	public User login(String username, String password) throws UserExistException {
		User user = userDao.selectUserByUsernameAndPassword(username, password);
		if(user != null){
			return user;
		}
		throw new UserExistException("�û������������,�����µ�¼");
	}

}
