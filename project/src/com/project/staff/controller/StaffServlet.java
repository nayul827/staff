package com.project.staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;



/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command= request.getParameter("command");
		System.out.println("StaffServlet에서 요청을 받음 확인"+command);
		ActionFactory af= ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action!=null){
			action.execute(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}
}
