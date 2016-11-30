package com.guest.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class GuestDaoTest {
	
	private static GuestDao dao;

	@BeforeClass
	public static void beforeDao() {
		dao = new GuestDao();
	}

	@Test
	public void testSelectAll(){
		try{
		List list =dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
		return;
		} catch(Exception ex){}
		fail("Not yet implemented");
	}
	@Test
	public void testInsertDelete() throws SQLException, Exception {
		GuestVo bean= new GuestVo(9999, "test", null, 9000);
		testInsertOne(bean);	//테스트입력
		testSelectOne(bean);	//테스트확인
		bean.setName("test2");
		bean.setPay(9090);
		testUpdateOne(bean);	//테스트수정
		testSelectOne(bean);	//테스트수정확인
		testDeleteOne(bean);	//테스트삭제
	}
	
	public void testInsertOne(GuestVo bean) throws SQLException, Exception{
		dao.insertOne(bean);
	}
	
	
	public void testSelectOne(GuestVo bean) throws SQLException, Exception {
		int sabun=bean.getSabun();
		GuestVo dto=dao.selectOne(sabun);
		assertNotNull(dto);
		assertEquals(bean, dto);
		System.out.println(dto);
	}
	
	public void testDeleteOne(GuestVo bean) throws SQLException, Exception{
		dao.deleteOne(bean.getSabun());
	}
	
	public void testUpdateOne(GuestVo bean) throws SQLException, Exception {
		dao.updateOne(bean);
		
	}
}
