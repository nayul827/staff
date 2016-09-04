package com.project.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.notice.dao.NoticeDao;
import com.project.notice.dto.NoticeDto;

public class NoticeUpdateAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeDto nDto =  new NoticeDto();
		
		nDto.setNoticenum(Integer.parseInt(request.getParameter("noticenum")));
		nDto.setWriter(request.getParameter("writer"));
		nDto.setPass(request.getParameter("pass"));
		nDto.setTitle(request.getParameter("title"));
		nDto.setContent(request.getParameter("content"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.updateNotice(nDto);
		
		new NoticeListAction().exectute(request, response);
	}
}
