package com.sinux.ssm.dao;

import java.util.List;
import com.sinux.ssm.entity.User;

public interface UserDao {
	public List<User> findAllUser();

	public List<User> findPageUser(int first, int rows);

	public List<User> findAllUserList(int str);

	public void savaUserList(User user);

	public int findUser(String num);

	public List<User> findUserInfo(User user);

	public String deleteUser(int[] uids) throws Exception;// 删除用户记录
}
