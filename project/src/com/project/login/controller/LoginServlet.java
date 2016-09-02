package com.project.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.login.dao.LoginDao;
import com.project.common.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("main/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "main/login.jsp";

		String empno = request.getParameter("empno");
		String pwd = request.getParameter("pwd");
		int manyn = Integer.parseInt(request.getParameter("manyn"));
		LoginDao sDao = LoginDao.getInstance();
		int result = sDao.userCheck(empno, pwd, manyn);
		HttpSession session = request.getSession();

		if (result == 0 || result == 1) {
			Dto sDto = sDao.getEmp(empno);

			if (sDto.getManyn() == 0) {
				session.setAttribute("manager", "y");
				session.setAttribute("loginUser", sDto.getEmpno());
				session.setAttribute("username", sDto.getEmpnm());
				request.setAttribute("message", "로그인 되었습니다.");
				url = "main/manager.jsp";
//				System.out.println(sDto.getManyn());
			} else if (sDto.getManyn() == 1) {
				session.setAttribute("loginUser", sDto.getEmpno());
				session.setAttribute("username", sDto.getEmpnm());
				request.setAttribute("message", "로그인 되었습니다.");
				url = "main/main.jsp";
			}
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
//		System.out.println("result : " + result + " url : " + url);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
