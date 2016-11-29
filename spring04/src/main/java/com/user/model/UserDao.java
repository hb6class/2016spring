package com.user.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hb.util.OraDB;

public class UserDao {
	
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserVo login(String id, String pw) throws SQLException, Exception{
		UserVo bean = new UserVo();
		String sql="SELECT 'TRUE' AS LOGIN, ID FROM USERS WHERE ID=? AND PW=?";
		try{
			pstmt=OraDB.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setLogin(rs.getString("login"));
				bean.setId(rs.getString("id"));
			}else{
				bean.setLogin("FALSE");
				bean.setId("guest");
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(OraDB.getConn()!=null)OraDB.getConn().close();
		}
		return bean;
	}
}











