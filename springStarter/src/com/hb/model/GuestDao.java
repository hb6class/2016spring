package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {
	
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String id="scott";
	private static String pw="tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GuestDao() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		conn=DriverManager.getConnection(url,id,pw);
	}

	public List selectAll() {
		String sql="select * from guest";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			List<GuestVo> list= new ArrayList<GuestVo>();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

}
