package com.project.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.ProjectDao;
import com.project.project.dto.ProjectDto;

public class ProjectViewAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "project/projectView.jsp";
		
		int ppronum = Integer.parseInt(request.getParameter("ppronum"));
		
		ProjectDao pDao = ProjectDao.getInstance();
		ProjectDto pDto = pDao.selectOneProjectByPpronum(ppronum);
		
		request.setAttribute("ppronum", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
