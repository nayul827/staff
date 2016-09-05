package com.project.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.notice.dao.NoticeDao;

public class NoticeDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int noticenum= Integer.parseInt(request.getParameter("noticenum"));
		
		NoticeDao nDao=NoticeDao.getInstance();
		nDao.deleteNotice(noticenum);
		
		new NoticeListAction().execute(request, response);
	}
}
