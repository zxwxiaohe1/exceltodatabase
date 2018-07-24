package com.sinux.ssm.service;

import java.util.List;

import javax.servlet.ServletException;

import com.sinux.ssm.entity.User;
/**
 * 接口用途:定义用户相关服务方法
 * */
public interface UserService {
	public List<User> findAllUser();
	public List<User> findPageUser(int first,int rows);//查询指定条数用户信息
	public List<User> findAllUserLists(int id);//根据指定ID查询用户信息
	public String savaUserList(User user);//保存用户信息
	public List<User> findUserInfo(User user);
	public int findUser(String number);
	public String deleteUser(int[] uids)throws Exception;//删除指定ID的用户信息
}
