package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;
import com.hb.model.GuestVo;

public class EditController implements Controller {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		if(req.getMethod().equals("GET")){
			return doGet(req, res);
		}else{
			return doPost(req, res);
		}
		
	}
	public ModelAndView doGet(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		String param=req.getParameter("idx");
		int sabun = Integer.parseInt(param);
		ModelAndView mav= new ModelAndView();
		GuestVo bean=dao.selectOne(sabun);
		mav.addObject("dto", bean);
		mav.setViewName("guest/editform");
		return mav;
	}
	public ModelAndView doPost(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav= new ModelAndView();
		
		dao.updateOne(new GuestVo(
				Integer.parseInt(req.getParameter("sabun"))
				,req.getParameter("name"),null
				,Integer.parseInt(req.getParameter("pay"))
				));
		mav.setViewName("redirect:/list.do");
		return mav;
	}
}
