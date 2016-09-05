package com.project.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.CrojectDao;
import com.project.project.dto.ProjectDto;

public class CrojectViewAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "project/crojectView.jsp";
		
		int cpronum = Integer.parseInt(request.getParameter("cpronum"));
		
		CrojectDao cDao = CrojectDao.getInstance();
		ProjectDto pDto = cDao.selectOneProjectByCpronum(cpronum);
		
		request.setAttribute("cpronum", pDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
