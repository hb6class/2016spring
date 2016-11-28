package com.hb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		GuestDao dao = new GuestDao();
		List list =dao.selectAll();
		req.setAttribute("alist", list);
		ModelAndView mav= new ModelAndView();
		mav.setViewName("guest/list");
		return mav;
	}

}
