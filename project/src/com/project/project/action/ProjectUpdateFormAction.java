package com.project.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.project.dao.ProjectDao;
import com.project.project.dto.ProjectDto;

public class ProjectUpdateFormAction implements Action {
	@Override
	public void exectute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
			throws javax.servlet.ServletException ,java.io.IOException {
		String url = "project/projectUpdate.jsp";
		
		int ppronum = Integer.parseInt(request.getParameter("ppronum"));
		
		ProjectDao pDao = ProjectDao.getInstance();
		pDao.updatePproject(ppronum);
		
		ProjectDto pDto = pDao.selectOneProjectByPpronum(ppronum);
		
		request.setAttribute("project", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
