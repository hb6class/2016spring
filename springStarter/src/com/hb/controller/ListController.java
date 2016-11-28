package com.hb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;

public class ListController implements Controller {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		List list =dao.selectAll();
//		req.setAttribute("alist", list);
		ModelAndView mav= new ModelAndView();
		mav.addObject("alist", list);
		mav.setViewName("guest/list");
		return mav;
	}

}
