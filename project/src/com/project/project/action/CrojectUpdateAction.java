package com.project.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.CrojectDao;
import com.project.project.dto.ProjectDto;

public class CrojectUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectDto pDto = new ProjectDto();
		
		pDto.setCpronum(Integer.parseInt("cpronum"));
		pDto.setPwd(request.getParameter("pwd"));
		pDto.setCinitdt(request.getParameter("cinitdt"));
		pDto.setCoutdt(request.getParameter("coutdt"));
		pDto.setCpronm(request.getParameter("cpronm"));
		pDto.setCcontent(request.getParameter("ccontent"));
		
		CrojectDao cDao = CrojectDao.getInstance();
		cDao.updateCproject(pDto);
		
		new CrojectListAction().execute(request, response);
	}
}
