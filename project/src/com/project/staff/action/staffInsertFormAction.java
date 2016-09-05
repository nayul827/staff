package com.project.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.common.Action;
import com.project.common.Dto;
import com.project.login.dao.LoginDao;

public class staffInsertFormAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="staff/staffInsert.jsp";
		
		HttpSession session = request.getSession();
		
		String nm = (String) session.getAttribute("loginUser");
		LoginDao sDao = LoginDao.getInstance();
		Dto sDto = sDao.getEmp(nm);
		
		
		request.setAttribute("type", sDto.getManyn());
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
