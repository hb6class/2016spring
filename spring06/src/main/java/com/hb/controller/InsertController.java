package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.hb.model.GuestDao;
import com.hb.model.GuestVo;

public class InsertController extends AbstractCommandController {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		GuestVo bean = (GuestVo)command;
		dao.insertOne(bean);
		return new ModelAndView("redirect:list.hb");
	}

}





