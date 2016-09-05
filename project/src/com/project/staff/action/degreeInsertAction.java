package com.project.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.degreeDto;

public class degreeInsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		degreeDto dDto = new degreeDto();
		
		System.out.println(request.getParameter("degreenum"));
		
		int degreenum = 0;
		if (request.getParameter("degreenum") != null){
			degreenum = Integer.parseInt(request.getParameter("degreenum"));
		}
		dDto.setDegreenum(degreenum);
		dDto.setFinaldegree(request.getParameter("finaldegree"));
		dDto.setCollegenm(request.getParameter("collegenm"));
		dDto.setMajor(request.getParameter("major"));
		dDto.setEntrandt(request.getParameter("entrandt"));
		dDto.setGradudt(request.getParameter("gradudt"));
		dDto.setEmpno(request.getParameter("empno"));
		
		staffDao sDao=staffDao.getIntance();
		
		int result=sDao.insertDegree(dDto);
		
		request.setAttribute("degreeList", dDto);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(dDto));
	}
}
