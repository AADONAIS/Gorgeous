package com.ado.solitu.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ado.solitu.entity.UserBean;
import com.ado.solitu.rowmapper.RowMapper;

public class UserRowmapper implements RowMapper {

	@Override
	public Object getRowMapper(ResultSet rs) throws SQLException {
		UserBean userbean=new UserBean();
		userbean.setU_id(rs.getInt("id"));
		userbean.setU_name(rs.getString("name"));
		userbean.setU_password(rs.getString("password"));
		userbean.setU_age(rs.getInt("age"));
		userbean.setU_gender(rs.getString("gender"));
		userbean.setU_phone(rs.getString("phone"));
		userbean.setU_auth(rs.getString("auth"));
		userbean.setU_address(rs.getString("address"));
		return userbean;
	}

}
