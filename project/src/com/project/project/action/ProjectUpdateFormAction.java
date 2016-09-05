package com.project.project.action;

import javax.servlet.RequestDispatcher;

import com.project.common.Action;
import com.project.project.dao.ProjectDao;
import com.project.project.dto.ProjectDto;

public class ProjectUpdateFormAction implements Action {
	@Override
	public void execute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
			throws javax.servlet.ServletException ,java.io.IOException {
		String url = "project/projectUpdate.jsp";
		
		int ppronum = Integer.parseInt(request.getParameter("ppronum"));
		
		ProjectDao pDao = ProjectDao.getInstance();
		ProjectDto pDto = pDao.selectOneProjectByPpronum(ppronum);
		
		request.setAttribute("project", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
