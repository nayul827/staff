package com.project.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.common.DBManager;
import com.project.project.dto.ProjectDto;

public class ProjectDao {
	private ProjectDao(){
		
	}
	private static ProjectDao instance = new ProjectDao();
	
	public static ProjectDao getInstance(){
		if(instance == null) {
			instance = new ProjectDao();
		}
		return instance;
	}
	public List<ProjectDto> selectAllMember(){
		String sql = "select * from emp";
		List<ProjectDto> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ProjectDto pDto = new ProjectDto();
				
				pDto.setPpronum(rs.getInt("ppronum"));
				pDto.setEmpno(rs.getString("empno"));
				pDto.setPpronm(rs.getString("ppronm"));
				pDto.setWdt(rs.getString("wdt"));
				
				list.add(pDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public void insertProject(ProjectDto pDto) {
		String sql = "insert into pproject("
				+ "PPRONUM,PREGIDT,PINITDT,POUTDT,PPRONM,PCONTENT,EMPNO,WORKNUM,CAREERNUM)"
				+ "values(ppronum,?,?,?,?,?,?,?,?)";
	}
	
}
