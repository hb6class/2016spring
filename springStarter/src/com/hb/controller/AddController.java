package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;
import com.hb.model.GuestVo;

public class AddController implements Controller {
	GuestDao dao;
	public AddController(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		GuestVo bean = new GuestVo(
				Integer.parseInt(req.getParameter("sabun"))
				, req.getParameter("name"), null
				, Integer.parseInt(req.getParameter("pay")));
		
		dao.insertOne(bean);
		mav.setViewName("redirect:/list.do");
		return mav;
	}

}
