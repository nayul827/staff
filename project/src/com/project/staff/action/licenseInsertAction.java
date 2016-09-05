package com.project.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.common.Action;
import com.project.staff.dao.staffDao;
import com.project.staff.dto.licenseDto;

public class licenseInsertAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		licenseDto lDto =  new licenseDto();
		
		lDto.setLicensenum(request.getParameter("licensenum"));
		lDto.setLicensenm(request.getParameter("licensenm"));
		lDto.setGetdt(request.getParameter("getdt"));
		lDto.setLicenseoffice(request.getParameter("licenseoffice"));
		lDto.setEmpno(request.getParameter("empno"));
		
		
		staffDao sDao= staffDao.getIntance();
		
		int result= sDao.insertLicense(lDto);
		
		if(result==1){
			result= sDao.lastInsert();
		}
		licenseDto llDto=sDao.lastInsertt(result);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(llDto));
	}
}
