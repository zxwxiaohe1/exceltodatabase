package com.sinux.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinux.ssm.dao.UserDao;
import com.sinux.ssm.entity.User;
import com.sinux.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllUserLists(int id) {
		return userDao.findAllUserList(id);
	}

	@Override
	public String savaUserList(User user) {
		String result = "faild";
		try {
			userDao.savaUserList(user);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<User> findUserInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.findUserInfo(user);
	}

	@Override
	public int findUser(String number) {
		return userDao.findUser(number);

	}

	@Override
	public List<User> findPageUser(int first, int rows) {
		// TODO Auto-generated method stub
		return userDao.findPageUser(first,rows);
	}

	@Override
	public String deleteUser(int[] uids) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(uids);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

}
