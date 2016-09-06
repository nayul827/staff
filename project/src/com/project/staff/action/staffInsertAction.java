package com.project.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.staffDto;

public class staffInsertAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		staffDto sDto = new staffDto();
		
		HttpSession session= request.getSession();
		String sessionEmpno = (String)session.getAttribute("empno");
		
		sDto.setEmpno(sessionEmpno);
		sDto.setEmpnm(request.getParameter("empnm"));
		sDto.setJuminno(request.getParameter("juminno"));
		sDto.setEmail(request.getParameter("email"));
		sDto.setPhone(request.getParameter("phone"));
		sDto.setEmp_img(request.getParameter("emp_img"));
		sDto.setIndt(request.getParameter("indt"));
		sDto.setOutdt(request.getParameter("outdt"));
		sDto.setAddrno(request.getParameter("addrno"));
		sDto.setSalary(Integer.parseInt(request.getParameter("salary")));
		sDto.setWdt(request.getParameter("wdt"));
		sDto.setDeptno(Integer.parseInt(request.getParameter("deptno")));		
		sDto.setRanknum(Integer.parseInt(request.getParameter("ranknum")));
		
		staffDao sDao = staffDao.getIntance();
		sDao.insertStaff(sDto, sessionEmpno);
		response.sendRedirect("StaffServlet?command=staff_view");
		
	}
}
