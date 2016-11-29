package com.user.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserDaoTest {
	private static UserDao dao;
	
	@BeforeClass
	public static void beforeDao(){
		dao = new UserDao();
	}
	
	@Test
	public void testLogin() throws SQLException, Exception {
		UserVo bean = dao.login("admin", "1234");
		assertTrue("TRUE".equals(bean.getLogin()));
		bean = dao.login("root", "1234");
		assertTrue("FALSE".equals(bean.getLogin()));
		bean = dao.login("admin", "1111");
		assertTrue("FALSE".equals(bean.getLogin()));
		bean = dao.login("root", "1111");
		assertTrue("FALSE".equals(bean.getLogin()));
	}

}
