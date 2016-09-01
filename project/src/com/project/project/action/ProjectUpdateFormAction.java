package com.project.project.action;

import javax.servlet.RequestDispatcher;

import com.project.common.Action;

public class ProjectUpdateFormAction implements Action {
	public void exectute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
			throws javax.servlet.ServletException ,java.io.IOException {
		String url = "project/projectUpdate.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
