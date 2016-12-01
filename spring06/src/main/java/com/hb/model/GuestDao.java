package com.hb.model;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GuestDao extends SqlMapClientDaoSupport {
	
	public List selectAll() {
			
		SqlMapClientTemplate template = getSqlMapClientTemplate();
		return template.queryForList("selectAll");
	}
}
