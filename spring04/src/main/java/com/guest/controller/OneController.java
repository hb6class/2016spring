package com.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.guest.model.GuestDao;
import com.guest.model.GuestVo;

public class OneController extends AbstractController {
	private GuestDao dao;
	private String page;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav= new ModelAndView();
		String param=req.getParameter("idx");
		int sabun = Integer.parseInt(param);
		mav.addObject("dto", dao.selectOne(sabun));
		mav.setViewName("guest/"+page);
		return mav;
	}

}
