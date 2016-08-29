package com.project.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.staffDto;

public class staffUpdateFormAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="staff/staffUpdate.jsp";
		
//		int empno= Integer.parseInt(request.getParameter("empno"));
		
//		staffDao sDao= staffDao.getIntance();
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
