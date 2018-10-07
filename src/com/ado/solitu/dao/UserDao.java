package com.ado.solitu.dao;

import java.sql.SQLException;
import java.util.List;

import com.ado.solitu.entity.UserBean;
import com.ado.solitu.rowmapper.impl.UserRowmapper;
import com.ado.solitu.util.JDBCTemplate;

@SuppressWarnings("all")
public interface UserDao {

	/**
	 * ��ѯ����
	 * @return
	 * @throws SQLException
	 */
	public List<UserBean> queryAll() throws SQLException ;
	
	/**
	 * ͨ��id�����û�
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public UserBean queryById(int id) throws SQLException; 
	
	/**
	 * �޸��û�
	 * @param id
	 * @throws SQLException
	 */
	public int modifyUser(UserBean userBean,int id) throws SQLException;
	
	/**
	 * ɾ���û�
	 * @param id
	 * @throws SQLException
	 */
	public int deleteUser(int id) throws SQLException;
	
	/**
	 * �����û�
	 * @param userBean
	 * @return
	 * @throws SQLException
	 */
	public int addUser(UserBean userBean) throws SQLException;
}
