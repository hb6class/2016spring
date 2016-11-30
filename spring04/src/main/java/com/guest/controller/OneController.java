package com.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.guest.model.GuestDao;
import com.guest.model.GuestVo;

public class OneController extends AbstractController {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav= new ModelAndView();
		String param=req.getParameter("idx");
		int sabun = Integer.parseInt(param);
		mav.addObject("bean", dao.selectOne(sabun));
		mav.setViewName("guest/detail");
		return mav;
	}

}
