package com.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.guest.model.GuestDao;

public class DeleteController implements Controller {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String param = req.getParameter("idx");
		int sabun = Integer.parseInt(param);
		dao.deleteOne(sabun);
		return new ModelAndView("redirect:list.do");
	}

}
