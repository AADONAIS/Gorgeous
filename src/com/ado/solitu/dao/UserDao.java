package com.ado.solitu.dao;

import java.sql.SQLException;
import java.util.List;

import com.ado.solitu.entity.UserBean;
import com.ado.solitu.rowmapper.impl.UserRowmapper;
import com.ado.solitu.util.JDBCTemplate;

@SuppressWarnings("all")
public interface UserDao {

	/**
	 * 查询所有
	 * @return
	 * @throws SQLException
	 */
	public List<UserBean> queryAll() throws SQLException ;
	
	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public UserBean queryById(int id) throws SQLException; 
	
	/**
	 * 修改用户
	 * @param id
	 * @throws SQLException
	 */
	public int modifyUser(UserBean userBean,int id) throws SQLException;
	
	/**
	 * 删除用户
	 * @param id
	 * @throws SQLException
	 */
	public int deleteUser(int id) throws SQLException;
	
	/**
	 * 增加用户
	 * @param userBean
	 * @return
	 * @throws SQLException
	 */
	public int addUser(UserBean userBean) throws SQLException;
}
