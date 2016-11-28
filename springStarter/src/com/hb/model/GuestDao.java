package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.OraDB;

public class GuestDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public GuestDao() throws Exception {
	}

	public List selectAll() {
		String sql="select * from guest";
		try {
			conn=OraDB.getConn();
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
		} catch (Exception e) {
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

	public void insertOne(GuestVo bean) {
		String sql="insert into guest values (?,?,sysdate,?)";
		try {
			conn=OraDB.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
	}

}
