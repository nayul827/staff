package com.project.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.ProjectDao;

public class ProjectDeleteAction implements Action {
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int Ppronum = Integer.parseInt(request.getParameter("ppronum"));
		
		ProjectDao pDao = ProjectDao.getInstance();
		pDao.deletePproject(Ppronum);
		
		new ProjectListAction().exectute(request, response);
	}
}
