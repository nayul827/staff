package com.project.staff.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.common.Action;
import com.project.staff.dao.addrnoDao;
import com.project.staff.dto.addrnoDto;

public class addrListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<addrnoDto> list= new ArrayList<>();
		String search= request.getParameter("search");
		addrnoDao aDao= addrnoDao.getInstance();
		System.out.println(search);
		list= aDao.selectAllAddr(search);
		addrnoDto aDto = new addrnoDto();
		System.out.println(aDto.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(list));
	}
}
