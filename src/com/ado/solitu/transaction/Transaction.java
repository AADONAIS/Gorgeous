package com.ado.solitu.transaction;
import java.sql.SQLException;
/**
 * ����ӿ�
 * @author Administrator
 *
 */
public interface Transaction {

	//��������
	public void beginTransation() ;
	//�ύ����
	public void commit();
	//�ع�����
	public void rollback();
}
