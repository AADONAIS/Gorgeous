package com.ado.solitu.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.ado.solitu.transaction.Transaction;
import com.ado.solitu.util.JDBCUtil;
/**
 * 事务实现接口类
 * @author Administrator
 *
 */
public class TransactionImpl  implements Transaction{

	@Override
	public void beginTransation() {
		try {
			JDBCUtil.getConnection().setAutoCommit(false); //将自动提交功能关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void commit() {
		try {
			JDBCUtil.getConnection().commit();//如果不出现异常应该进行事务提交操作
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();;  //将该连接给关闭
		}
	}

	@Override
	public void rollback() {
		try {
			JDBCUtil.getConnection().rollback();//如果异常，应该讲事务回滚
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();;   //将连接关闭
		}
	}
}
