package com.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.guest.model.GuestDao;
import com.guest.model.GuestVo;

public class ListController implements Controller {
	private GuestDao dao;
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		//세션 검사
		HttpSession session = req.getSession();
		Object result = session.getAttribute("result");
		if(result!=null && (Boolean)result){
			mav.addObject("loginOk",result);
		}else{
			mav.addObject("loginGo",true);			
		}
		
		List<GuestVo> list = dao.selectAll();
		mav.addObject("alist", list);
		mav.setViewName("guest/list");
		return mav;
	}

}








