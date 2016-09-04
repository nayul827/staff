package com.project.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.project.dao.CrojectDao;

public class CrojectDeleteAction implements Action {
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cpronum = Integer.parseInt(request.getParameter("cpronum"));
		
		CrojectDao cDao = CrojectDao.getInstance();
		cDao.deleteCproject(cpronum);
		
		new CrojectListAction().exectute(request, response);
	}
}
