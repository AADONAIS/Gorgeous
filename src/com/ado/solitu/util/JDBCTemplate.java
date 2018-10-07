package com.ado.solitu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ado.solitu.rowmapper.RowMapper;

public class JDBCTemplate {

	/**
	 * 修改功能
	 * @param sql
	 * @param rowmapper
	 * @param objects
	 * @return
	 * @throws SQLException
	 */
	public static int excuteUpdate(String sql,Object...objects) throws SQLException {
		int rows = -1;
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement(sql);
		if(null!=objects&&objects.length>0) {
			for(int i=0;i<objects.length;i++) {
			ps.setObject((i+1), objects[i]);
			}
		}
		rows=ps.executeUpdate();
		closeTemplate(null, ps);
		JDBCUtil.closeConnection();
		return rows;
	}

	/**
	 * 查询功能
	 * @param sql
	 * @param rowmapper
	 * @param objects
	 * @return
	 * @throws SQLException
	 */
	public static List<Object> excuteQuery(String sql,RowMapper rowmapper,Object...objects) throws SQLException{
		   List<Object> list=new ArrayList<Object>();
		   Connection connection=JDBCUtil.getConnection();
		   PreparedStatement ps=connection.prepareStatement(sql);
		   if(objects!=null && objects.length>0) {
			   for(int i=0;i<objects.length;i++) {
				   ps.setObject((i+1),objects[i]);
			   }
		   }
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   Object obj=rowmapper.getRowMapper(rs);
			   list.add(obj);
		   }
		   closeTemplate(rs, ps);
		   JDBCUtil.closeConnection();
		   return list;
		   	
	}
	/**
	 * 关闭
	 * @param rs
	 * @param ps
	 */
	public static void closeTemplate(ResultSet rs,PreparedStatement ps) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
