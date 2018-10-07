package com.ado.solitu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ado.solitu.dao.UserDao;
import com.ado.solitu.entity.UserBean;
import com.ado.solitu.rowmapper.impl.UserRowmapper;
import com.ado.solitu.util.JDBCTemplate;

@SuppressWarnings("all")
public class UserDaoImpl  implements UserDao{

	@Override
	public List<UserBean> queryAll() throws SQLException {
		List<UserBean> userList = new ArrayList<UserBean>();
		String sql="select * from user;";
		List<Object> list=JDBCTemplate.excuteQuery(sql, new UserRowmapper());
	    for (Object object : list) {
			userList.add((UserBean) object);
		}
	    return userList;
	}

	@Override
	public UserBean queryById(int id) throws SQLException {
		String sql="select * from user where id=?";
		List<?> list=JDBCTemplate.excuteQuery(sql, new UserRowmapper(), id);
		return list.size()>0?(UserBean)list.get(0):null;
	}

	@Override
	public int modifyUser(UserBean userBean,int id) throws SQLException {
		String sql="update user set name=?,age=?,address=? where id=?";
		return JDBCTemplate.excuteUpdate(sql,userBean.getU_name(),userBean.getU_age(),userBean.getU_address(),id);
		
	}

	@Override
	public int deleteUser(int id) throws SQLException {
		String sql="delete from user where id=?";
		return JDBCTemplate.excuteUpdate(sql, id);
	}

	@Override
	public int addUser(UserBean userBean) throws SQLException {
		String sql="insert into user(id,name,password,gender,age,phone,address,auth) value(?,?,?,?,?,?,?,?);";
		return JDBCTemplate.excuteUpdate(sql,userBean.getU_id(),userBean.getU_name(),userBean.getU_password(),userBean.getU_gender(),userBean.getU_age(),userBean.getU_phone(),userBean.getU_address(),userBean.getU_auth());
	}
	

}
