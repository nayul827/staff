package com.project.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.CrojectDao;
import com.project.project.dto.ProjectDto;

public class CrojectListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/project/crojectList.jsp";
		
		CrojectDao cDao = CrojectDao.getInstance();
		List<ProjectDto> crojectList = cDao.selectAllMember();
		
		request.setAttribute("crojectList", crojectList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
