package com.project.staff.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.addrnoDto;
import com.project.staff.dto.staffDto;

public class StaffAddrAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dong= request.getParameter("dong");
		List<addrnoDto> list= new ArrayList<>();
		staffDao sDao= staffDao.getIntance();
//		addrnoDto= sDao.zip(dong);
		
	      String obj = "";
//	      for(addrnoDto a: sDto){
//	       obj += "<tr><td><input type='button' value='"+a.getSido()+"' onclick='zip_chk(\""+a.getZipCode()+"\",\""+a.getSIDO()+a.getGUGUN()+a.getDONG()+a.getRI()+a.getBLDG()+a.getBUNGI()+"\");'></td><td>"
	            
//	      }
	      PrintWriter out = response.getWriter();
	      out.print(obj);
	      
	}
}
