package com.hb.model;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GuestDao extends SqlMapClientDaoSupport {
	
	public List selectAll() {
			
		SqlMapClientTemplate template = super.getSqlMapClientTemplate();
		return template.queryForList("selectAll");
	}
	
	public void insertOne(GuestVo bean){
		SqlMapClientTemplate template = super.getSqlMapClientTemplate();
		template.insert("insertOne",bean);
	}
	public GuestVo selectOne(int sabun){
		SqlMapClientTemplate template = super.getSqlMapClientTemplate();
		return (GuestVo)template.queryForObject("selectOne", sabun);
	}
	public void updateOne(GuestVo bean){
		SqlMapClientTemplate template = super.getSqlMapClientTemplate();
		template.update("updateOne", bean);
	}
	public void deleteOne(int sabun){
		SqlMapClientTemplate template = super.getSqlMapClientTemplate();
		template.delete("deleteOne", sabun);
	}
}















