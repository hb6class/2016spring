package com.hb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.model.GuestDao;
import com.hb.model.GuestVo;

public class DetailController implements Controller {
	private GuestDao dao;
	private String path;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(request.getServletPath());
		String url="guest/"+path;
//		if(request.getServletPath().equals("/edit.hb")){
//			url+="editform";
//		}else{
//			url+="detail";
//		}
		String param=request.getParameter("idx");
		int sabun = Integer.parseInt(param);
		GuestVo bean=dao.selectOne(sabun);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", bean);
		mav.setViewName(url);
		return mav;
	}

}
