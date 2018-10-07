package com.ado.solitu.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ado.solitu.dao.UserDao;
import com.ado.solitu.dao.impl.UserDaoImpl;
import com.ado.solitu.entity.UserBean;
import com.ado.solitu.exception.MyException;
import com.ado.solitu.object.factory.ObjectFactory;
import com.ado.solitu.service.UserService;
import com.ado.solitu.service.impl.UserServiceImpl;

import junit.framework.TestResult;

public class Test implements junit.framework.Test{

	@org.junit.Test
	public void test() {
		
		UserService userservice=(UserService) ObjectFactory.getObject("UserService");
		List<UserBean> userlist=new ArrayList<UserBean>();
		try {
			userlist=userservice.login();
			for (UserBean userBean : userlist) {
				System.out.println(userBean.getU_name());
				System.out.println(userBean.getU_password());
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int countTestCases() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void run(TestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
