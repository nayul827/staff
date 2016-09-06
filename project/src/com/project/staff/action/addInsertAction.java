package com.project.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.common.Action;
import com.project.staff.dao.addrnoDao;
import com.project.staff.dto.addrnoDto;

public class addInsertAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		addrnoDto aDto= new addrnoDto();
		
		aDto.setAddrno(Integer.parseInt(request.getParameter("addrno")));
		aDto.setZipcode(request.getParameter("zipcode"));
		aDto.setSido(request.getParameter("sido"));
		aDto.setSigungu(request.getParameter("sigungu"));
		aDto.setDong(request.getParameter("dong"));
		aDto.setRi(request.getParameter("ri"));
		aDto.setBldg(request.getParameter("bldg"));
		aDto.setBungi(request.getParameter("bungi"));
		
		
		addrnoDao aDao= addrnoDao.getInstance();
		
		int result = aDao.insertAddr(aDto);
		
		request.setAttribute("addrList", aDto);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(aDao));
	}
}
