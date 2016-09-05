package com.project.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.common.Action;
import com.project.project.dao.ProjectDao;
import com.project.project.dto.ProjectDto;

public class ProjectInsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectDto pDto = new ProjectDto();
		
		pDto.setPpronum(Integer.parseInt(request.getParameter("ppronum")));
		pDto.setPinitdt(request.getParameter("pinitdt"));
		pDto.setPoutdt(request.getParameter("poutdt"));
		pDto.setPpronm(request.getParameter("ppronm"));
		pDto.setPcontent(request.getParameter("pcontent"));
		pDto.setEmpno(request.getParameter("empno"));
		pDto.setWorknum(Integer.parseInt(request.getParameter("worknum")));
		pDto.setCareernum(Integer.parseInt(request.getParameter("careernum")));
		
		ProjectDao pDao = ProjectDao.getInstance();
		pDao.insertProject(pDto);

		new CrojectListAction().execute(request, response);
	}
}
