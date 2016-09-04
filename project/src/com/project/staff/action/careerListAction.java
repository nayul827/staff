package com.project.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.careerDto;

public class careerListAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url="staff/staffInsert_bak.jsp";
		
		staffDao cDao = staffDao.getIntance();
		
		List<careerDto> careeList= cDao.selectAllCareer();
		
		request.setAttribute("careerList", careeList);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
