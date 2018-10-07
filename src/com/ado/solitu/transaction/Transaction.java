package com.ado.solitu.transaction;
import java.sql.SQLException;
/**
 * 事务接口
 * @author Administrator
 *
 */
public interface Transaction {

	//开启事务
	public void beginTransation() ;
	//提交事务
	public void commit();
	//回滚事务
	public void rollback();
}
