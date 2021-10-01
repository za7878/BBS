package com.human.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private SqlSession sqlSession;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		return "home";
//	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String insertBBS(HttpServletRequest hsr) {
		String pTitle = hsr.getParameter("title");
		String pContent = hsr.getParameter("content");
		String pWriter = hsr.getParameter("writer");
		String pPasscode = hsr.getParameter("passcode");
		System.out.println("title ["+pTitle+"] content ["+pContent+"] writer ["+pWriter+"] passcode ["+pPasscode+"]");
		//insert into DB table
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		System.out.println("ok");
		bbs.writerbbs(pTitle, pContent, pWriter, pPasscode);
		return "redirect:/list"; // 해당하는 RequestMapping으로 이동, method 실행.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deleteBBS(HttpServletRequest hsr) {
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		int bbs_id=5;
		bbs.deleteBBS(bbs_id);
		return "redirect:/list";
	}
	@RequestMapping(value="/view/{bbs_id}",method=RequestMethod.GET)
	public String selectOneBBS(@PathVariable("bbs_id") int bbs_id, Model model) {
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		BBSrec post=bbs.getPost(bbs_id);
		model.addAttribute("post",post);
		return "view";
	}
	
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	public String updateBBS(HttpServletRequest hsr) {
//		iBBS bbs=sqlSession.getMapper(iBBS.class);
//		int bbs_id=Integer.parseInt(hsr.getParameter("bbs_id"));
//		String Title = hsr.getParameter("title");
//		String Content = hsr.getParameter("content");
//		bbs.updateBBS(bbs_id,Title,Content);
//		return "redirect:/list";
//	}
	
	@RequestMapping("/new")
	public String anew() {
		return "new";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String alist(Model model) {
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		ArrayList<BBSrec> alBBS=bbs.getList();
		model.addAttribute("list_BBS",alBBS);
		return "list";
	}

	@RequestMapping(value="/delete/{bbs_id}",method=RequestMethod.GET)
	public String deleteBBS(@PathVariable("bbs_id") int bbs_id) {
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		bbs.deleteBBS(bbs_id);
		return "redirect:/list";
	}
	@RequestMapping(value="/update/{bbs_id}",method=RequestMethod.GET)
	public String updateBBS(@PathVariable("bbs_id") int bbs_id, Model model) {
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		String title = null;
		String content = null;
		// Mybatis호출 ->
		// 받아온 데이터를 update.jsp로 전달. using Model
		BBSrec rec=bbs.getPost(bbs_id);
		model.addAttribute("post", rec);
		return "update";
	}
	@RequestMapping(value="updateView",method=RequestMethod.POST)
	public String updateView(HttpServletRequest hsr) {
		int bbs_id=Integer.parseInt(hsr.getParameter("bbs_id"));
		String title=hsr.getParameter("title");
		String content=hsr.getParameter("content");
		iBBS bbs=sqlSession.getMapper(iBBS.class);
		bbs.updateBBS(bbs_id,title,content);
		return "redirect:/list";
	}
}