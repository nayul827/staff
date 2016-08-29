package com.project.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.notice.dao.NoticeDao;
import com.project.notice.dto.NoticeDto;

public class NoticeCheckPassAction implements Action{
	@Override
	public void exectute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=null;
		
		int noticenum=Integer.parseInt(request.getParameter("noticenum"));
		String pass =  request.getParameter("pass");
		
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto nDto = nDao.selectOneNoticeByNoticeNum(noticenum);
		
		if(nDto.getPass().equals(pass)){
			url="/notice/checkSuccess.jsp";
		}else{
			url="/notice/noticeCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
