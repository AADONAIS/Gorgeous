package com.ado.solitu.service;

import java.util.List;

import com.ado.solitu.entity.UserBean;
import com.ado.solitu.exception.MyException;

public interface UserService {

	public List<UserBean> login() throws MyException;
	
	public UserBean queryById(int id) throws MyException;
	
	public void updateUser(UserBean userBean,int id) throws MyException;
	
	public void deleteUser(int id) throws MyException;
	
	public void addUser(UserBean userBean) throws MyException;
}
