package com.hb.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dodo.model.GuestVo;

public class GuestDaoTest {
	private static GuestDao dao;
	private static JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static void testBefore(){
		BasicDataSource dataSource=new BasicDataSource();
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="scott";
		String password="tiger";
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		// <bean id="dataSource" 
		jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		// <bean id="jdbcTemplate"
		
		dao= new GuestDao();
		dao.setJdbcTemplate(jdbcTemplate);
		// <bean id="dao2"
	}

	@Test
	public void testSelectAll() {
		List<GuestVo> list=dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
	}
	
	@Test
	public void testCRUL(){
		GuestVo bean =new GuestVo(9999, "test", null, 9000);
		int result=dao.insertOne(bean);
		assertFalse(result==0);
		assertSame(1, result);
		
		bean.setName("edit");
		bean.setPay(9090);
		result=dao.updateOne(bean);
		assertFalse(result==0);
		
		result=dao.deleteOne(9999);
		assertFalse(result==0);
	}
	
	
	public void testInsertOne() {
		((BasicDataSource)jdbcTemplate.getDataSource()).setDefaultAutoCommit(false);
		int result=dao.insertOne(new GuestVo(9999, "test", null, 9000));
		assertFalse(result==0);
		assertSame(1, result);
		((BasicDataSource)jdbcTemplate.getDataSource()).setDefaultAutoCommit(true);
	}

	
	public void testUpdate(){
		GuestVo bean =new GuestVo(9999, "test", null, 9000);
		dao.insertOne(bean);
		bean.setName("edit");
		bean.setPay(9090);
		int result=dao.updateOne(bean);
		assertFalse(result==0);
		dao.deleteOne(bean.getSabun());
	}
	
	
	public void testDelete(){
		GuestVo bean =new GuestVo(9999, "test", null, 9000);
		dao.insertOne(bean);
		int result=dao.deleteOne(9999);
		assertFalse(result==0);		
	}
}









