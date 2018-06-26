package com.calbook.web.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calbook.web.dao.MembersDAO;
import com.calbook.web.util.CookieManager;
import com.calbook.web.vo.Members;

@Controller
//@RequestMapping("/*")
public class IndexController {

	@Autowired
	private SqlSession ss;
	
	
	/* ����ȭ�� */
	@RequestMapping(value={"index.do"}, method=RequestMethod.GET)
	public String login(String error, Model model, HttpServletRequest request) {
		// ��Ű���� �ҷ�����
		Cookie[] coos = request.getCookies();
		String ckEmail = CookieManager.getCookie(coos, "email");
		String ckPwd = CookieManager.getCookie(coos, "pwd");
		System.out.println("��Ű email: " + ckEmail);
		System.out.println("��Ű pwd: " + ckPwd);

		System.out.println("session: " + request.getSession().getAttribute("email"));
		// �α��� ���� ���� Ȯ��
		if(error != null && !error.equals("")) {
			model.addAttribute("errorMsg", "�̸��� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}

		model.addAttribute("ckEmail", ckEmail);
		model.addAttribute("ckPwd", ckPwd);

		return "index.jsp";
	}


	/* �̸��� �ߺ� üũ */
	@RequestMapping(value = {"idCheck.do"}, method = RequestMethod.GET)
	@ResponseBody
	public String idcheck(String email, HttpServletRequest request, HttpServletResponse response) {
		MembersDAO mdao = ss.getMapper(MembersDAO.class);
		Members m =mdao.getMembersEmail(email);

		if(m == null) {
			return "ok";
		}else {
			return "not ok";
		}
	}
	
	/* �г��� �ߺ� üũ */
	@RequestMapping(value = {"nickCheck.do"}, method = RequestMethod.GET)
	@ResponseBody
	public String nickcheck(String nick, HttpServletRequest request, HttpServletResponse response) {
		MembersDAO mdao = ss.getMapper(MembersDAO.class);
		Members m =mdao.getMembersNick(nick);
		if(m == null) {
			return "ok";
		}else {
			return "not ok";
		}
	}
	
	
	
	/* ȸ������ proc (�������� ����) */
	@RequestMapping(value= {"join.do"}, method=RequestMethod.POST)
	public String join(Members m) {
		MembersDAO mdao = ss.getMapper(MembersDAO.class);
		int af = mdao.addMembers(m);
		if(af==1) {
			System.out.println("ȸ�����Լ���");
			return "redirect:index.do";
		}else {
			System.out.println("ȸ�����Խ���");
			return "index.jsp";
		}
	}


	/* �α��� Proc */
	@RequestMapping(value={"login.do"}, method=RequestMethod.POST)
	@ResponseBody
	public String login(String email, String pwd, String checkLogin, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("email1: " + email);
		System.out.println("pwd1: " + pwd);
		System.out.println("checkLogin: " + checkLogin);

		HttpSession session = request.getSession();
		MembersDAO mdao = ss.getMapper(MembersDAO.class);
		Members m = mdao.getMembersEmail(email);
		//String json = "{\"mid\":\"SEA\",\"pwd\":\"123\"}";
		//System.out.println(json);

		if(m == null) {
			System.out.println("�̸����� Ʋ�Ƚ��ϴ�.");
			return "no";
		}else if(!m.getPwd().equals(pwd)) {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return "no";
		}else {
			System.out.println(m.getEmail() + "�� �α��� ����");
			session.setAttribute("email", email);
			session.setAttribute("nick", m.getNick());
			// �α��� ���� ��Ű ����&����(email, pwd)
			if(checkLogin.equals("true")) {
				Cookie ckEmail = new Cookie("email", email);
				Cookie ckPwd = new Cookie("pwd", pwd);
				ckEmail.setMaxAge(60*60*24*30);
				ckPwd.setMaxAge(60*60*24*30);
				response.addCookie(ckEmail);
				response.addCookie(ckPwd);
				System.out.println("�α��� ���� ��Ű(ckEmail) ����: " + email + ", " + pwd);
			}else if(checkLogin.equals("false")) {
				Cookie ckEmail = new Cookie("email", null);
				Cookie ckPwd = new Cookie("pwd", null);
				ckEmail.setMaxAge(0);
				ckPwd.setMaxAge(0);
				response.addCookie(ckEmail);
				response.addCookie(ckPwd);
				System.out.println("�α��� ���� ��Ű(ckEmail) ����");
			}		

			//response.getWriter().write("ok");
			return "ok";
		}
	}
	
	
	/* �α׾ƿ� */
	@RequestMapping(value= {"logout.do"}, method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("email", null);
		session.setAttribute("nick", null);
		return "redirect:index.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
