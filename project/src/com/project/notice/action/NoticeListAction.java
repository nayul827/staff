package com.project.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.notice.dao.NoticeDao;
import com.project.notice.dto.NoticeDto;

public class NoticeListAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="/notice/noticeList.jsp";
		
		NoticeDao nDao= NoticeDao.getInstance();
		
		List<NoticeDto> noticeList=nDao.selectAllNotice();
		
		request.setAttribute("noticeList", noticeList);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
