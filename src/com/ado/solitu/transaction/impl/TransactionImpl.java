package com.ado.solitu.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.ado.solitu.transaction.Transaction;
import com.ado.solitu.util.JDBCUtil;
/**
 * ����ʵ�ֽӿ���
 * @author Administrator
 *
 */
public class TransactionImpl  implements Transaction{

	@Override
	public void beginTransation() {
		try {
			JDBCUtil.getConnection().setAutoCommit(false); //���Զ��ύ���ܹر�
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void commit() {
		try {
			JDBCUtil.getConnection().commit();//����������쳣Ӧ�ý��������ύ����
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();;  //�������Ӹ��ر�
		}
	}

	@Override
	public void rollback() {
		try {
			JDBCUtil.getConnection().rollback();//����쳣��Ӧ�ý�����ع�
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();;   //�����ӹر�
		}
	}
}
