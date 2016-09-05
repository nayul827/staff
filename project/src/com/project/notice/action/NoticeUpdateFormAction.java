package com.project.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.notice.dao.NoticeDao;
import com.project.notice.dto.NoticeDto;

public class NoticeUpdateFormAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String url="/notice/noticeUpdate.jsp";
		
		int noticenum= Integer.parseInt(request.getParameter("noticenum"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.updateReadCount(noticenum);
		
		NoticeDto nDto= nDao.selectOneNoticeByNoticeNum(noticenum);
		
		request.setAttribute("notice",nDto);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
