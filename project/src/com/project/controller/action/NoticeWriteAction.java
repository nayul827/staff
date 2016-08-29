package com.project.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.notice.dao.NoticeDao;
import com.project.notice.dto.NoticeDto;

public class NoticeWriteAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeDto nDto = new NoticeDto();
			
		HttpSession session = request.getSession();
		String sessionEmpno = (String)session.getAttribute("loginUser");
		
		
		nDto.setWriter(request.getParameter("writer"));
		nDto.setPass(request.getParameter("pass"));
		nDto.setTitle(request.getParameter("title"));
		nDto.setContent(request.getParameter("content"));
		nDto.setEmpno( sessionEmpno);
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.insertNotice(nDto);
		
		new NoticeListAction().exectute(request, response);
	}
}
