package com.project.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.common.Action;
import com.project.common.Dto;
import com.project.login.dao.LoginDao;

public class ProjectInsertFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "project/projectInsert.jsp";
		
		HttpSession session = request.getSession();
		
		String empno = (String) session.getAttribute("loginUser");
		LoginDao pDao = LoginDao.getInstance();
		Dto pDto = pDao.getEmp(empno);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
