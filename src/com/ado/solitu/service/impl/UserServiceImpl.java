package com.ado.solitu.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ado.solitu.dao.UserDao;
import com.ado.solitu.entity.UserBean;
import com.ado.solitu.exception.MyException;
import com.ado.solitu.object.factory.ObjectFactory;
import com.ado.solitu.service.UserService;
import com.ado.solitu.transaction.Transaction;

public class UserServiceImpl implements UserService{

	Transaction transaction=(Transaction) ObjectFactory.getObject("Transaction");
	@Override
	public List<UserBean> login() throws MyException {
		List<UserBean> userList=new ArrayList<UserBean>();
		UserDao userdao=(UserDao) ObjectFactory.getObject("UserDao");
		try {
			userList=userdao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/**
	 * 
	 */
	@Override
	public UserBean queryById(int id) throws MyException {
		UserBean userBean=new UserBean();
		UserDao userdao=(UserDao)ObjectFactory.getObject("UserDao");
		try {
			userBean=userdao.queryById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBean;
	}

	@Override
	public void updateUser(UserBean userBean,int id) throws MyException {
		UserDao userdao=(UserDao)ObjectFactory.getObject("UserDao");
		try {
			userdao.modifyUser(userBean,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) throws MyException {
		UserDao userdao=(UserDao)ObjectFactory.getObject("UserDao");
		try {
			userdao.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addUser(UserBean userBean) throws MyException {
		UserDao userdao=(UserDao) ObjectFactory.getObject("UserDao");
		try {
			userdao.addUser(userBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
