package com.project.staff.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.common.ActionUpload;

/**
 * Servlet implementation class StaffUploadServlet
 */
@WebServlet("/StaffUploadServlet")
public class StaffUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StaffUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context= getServletContext();
		String path=context.getRealPath("upload");
		String enctype= "UTF-8";
		int sizelimit=20*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(request, path,sizelimit,enctype,new DefaultFileRenamePolicy());
		
		String command= multi.getParameter("command");
		System.out.println("StaffUploadServlet에서 요청을 받음 확인"+command);
		ActionFactory af= ActionFactory.getInstance();
		ActionUpload actionUpload = af.getActionUpload(command);
		if(actionUpload!=null){
			actionUpload.exectute(multi, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
