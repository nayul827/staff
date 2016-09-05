package com.project.staff.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.project.common.Action;
import com.project.staff.dao.staffDao;

public class licenseDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int licensenum = Integer.parseInt(request.getParameter("licensenum"));
		
		staffDao sDao = staffDao.getIntance();
		int result= sDao.deleteLicense(licensenum);
		
		System.out.println("result"+result);
		JsonObject json = new JsonObject();
		if(result==1){
			json.addProperty("msg", "success");
		}
		else{
			json.addProperty("msg", "fail");
		}
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}
}
