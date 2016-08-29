package com.project.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.staffDto;

public class staffViewAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="staff/staffView.jsp";
		
		String empno= request.getParameter("empno");
		
		staffDao sDao= staffDao.getIntance();
		staffDto sDto= sDao.selectOneStaffByEmpNO(empno);
		request.setAttribute(empno, sDto);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
