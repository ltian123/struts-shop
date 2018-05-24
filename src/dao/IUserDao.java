package dao;

import entity.User;

public interface IUserDao {

	/**
	 * �û�ע��
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param username
	 * @param password
	 */
	public User selectUserByUsername(String username);
	
	/**
	 * �����û����������ѯ�û���Ϣ
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectUserByUsernameAndPassword(String username, String password);
	
	
	
	
}