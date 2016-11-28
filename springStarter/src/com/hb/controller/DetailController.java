package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;
import com.hb.model.GuestVo;

public class DetailController implements Controller {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String param=req.getParameter("idx");
		int sabun = Integer.parseInt(param);
		ModelAndView mav= new ModelAndView();
		GuestVo bean=dao.selectOne(sabun);
		mav.addObject("dto", bean);
		mav.setViewName("guest/detail");
		return mav;
	}

}
