package com.ado.solitu.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {

	
	public Object getRowMapper(ResultSet rs) throws SQLException; 
}
