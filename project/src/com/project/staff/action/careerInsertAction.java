package com.project.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.careerDto;

public class careerInsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		careerDto cDto = new careerDto();
		
		System.out.println(request.getParameter("careernum"));
		
		int careernum=0;
		if(request.getParameter("careernum")!=null){
			careernum= Integer.parseInt(request.getParameter("careernum"));
		}
		cDto.setCareernum(careernum);
		cDto.setFirmnm(request.getParameter("firmnm"));
		cDto.setEnterdt(request.getParameter("enterdt"));
		cDto.setOuterdt(request.getParameter("outerdt"));
		cDto.setPosition(request.getParameter("position"));
		cDto.setWorknm(request.getParameter("worknm"));
		
		staffDao cDao= staffDao.getIntance();
		int result= cDao.insertCareer(cDto);
		
		request.setAttribute("careerList", cDto);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(cDao));
	}
}
