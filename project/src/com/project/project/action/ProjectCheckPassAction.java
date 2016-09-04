package com.project.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.project.dao.ProjectDao;
import com.project.project.dto.ProjectDto;

public class ProjectCheckPassAction implements Action {
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = null;
		
		int ppronum = Integer.parseInt(request.getParameter("ppronum"));
		String pass = request.getParameter("pass");
		
		ProjectDao pDao = ProjectDao.getInstance();
		ProjectDto pDto = pDao.selectOneProjectByPpronum(ppronum);
		
		if(pDto.getPass().equals(pass)) {
			url="/project/checkSuccess.jsp";
		} else {
			url="/proejct/projectCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
