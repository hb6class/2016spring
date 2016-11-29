package com.hb.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class OraDB {
	private static String url="jdbc:oracle:thin:@203.236.209.193:1521:xe";
	private static String id="scott";
	private static String pw="tiger";
	private static Connection conn;
	
	public static Connection getConn() throws Exception {
		if(conn==null || conn.isClosed()){	
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url,id,pw);
		}
		return conn;
	}
}
