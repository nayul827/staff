package com.project.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.ProjectDao;
import com.project.project.dto.ProjectDto;

public class ProjectListAction implements Action {

	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/project/projectList.jsp";
		
		ProjectDao pDao = ProjectDao.getInstance();
		List<ProjectDto> projectList = pDao.selectAllMember();
		
		request.setAttribute("projectList", projectList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
