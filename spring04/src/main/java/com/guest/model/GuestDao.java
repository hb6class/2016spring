package com.guest.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.util.OraDB;

public class GuestDao {

	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<GuestVo> selectAll() throws SQLException, Exception {
		List<GuestVo> list= new ArrayList<GuestVo>();
		String sql="select * from guest order by sabun";
		try{
			pstmt=OraDB.getConn().prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						));
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(OraDB.getConn()!=null)OraDB.getConn().close();
		}
		return list;
	}

	public void insertOne(GuestVo bean) throws SQLException, Exception {
		String sql ="insert into guest values (?,?,sysdate,?)";
		try{
			pstmt=OraDB.getConn().prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(OraDB.getConn()!=null)OraDB.getConn().close();
		}
	}
	
	public void deleteOne(int sabun) throws SQLException, Exception {
		String sql ="delete from guest where sabun=?";
		try{
			pstmt=OraDB.getConn().prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(OraDB.getConn()!=null)OraDB.getConn().close();
		}
	}
	public GuestVo selectOne(int sabun) throws SQLException, Exception{
		String sql ="select * from guest where sabun=?";
		try{
			pstmt=OraDB.getConn().prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						);
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(OraDB.getConn()!=null)OraDB.getConn().close();
		}
		return null;
		
	}
	
	public void updateOne(GuestVo vo) throws SQLException, Exception {
		String sql="update guest set name=?,pay=? where sabun=?";
		try{
			pstmt=OraDB.getConn().prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPay());
			pstmt.setInt(3, vo.getSabun());
			pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(OraDB.getConn()!=null)OraDB.getConn().close();
		}
		
	}
}













