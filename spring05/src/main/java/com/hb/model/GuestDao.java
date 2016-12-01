package com.hb.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.mapper.Mapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dodo.model.GuestVo;

public class GuestDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<GuestVo> selectAll() {
		String sql="select * from guest";
		RowMapper<GuestVo> mapper=new RowMapper<GuestVo>() {

			@Override
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean = new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						);
				return bean;
			}
		};
		List list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	public void insertOne(GuestVo bean) {
		String sql="insert into guest values (?,?,sysdate,?)";
		Object[] obj ={bean.getSabun(),bean.getName(),bean.getPay()};
		jdbcTemplate.update(sql,obj);
	}

}









