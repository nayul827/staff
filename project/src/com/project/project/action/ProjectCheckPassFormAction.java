package com.project.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProjectCheckPassFormAction implements Action {
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/project/projectCheckPass.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
