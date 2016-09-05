package com.project.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				pDto.setPregidt(rs.getTimestamp("pregidt"));
				pDto.setPwd(rs.getString("pwd"));
				pDto.setPcontent(rs.getString("pcontent"));
				
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
				+ "PPRONUM,PINITDT,POUTDT,PPRONM,PCONTENT,EMPNO,WORKNUM,CAREERNUM,pwd)"
				+ "values(pproject_seq.nextval,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pDto.getPpronum());
			pstmt.setString(2, pDto.getPinitdt());
			pstmt.setString(3, pDto.getPoutdt());
			pstmt.setString(4, pDto.getPpronm());
			pstmt.setString(5, pDto.getPcontent());
			pstmt.setString(6, pDto.getEmpno());
			pstmt.setInt(7, pDto.getCareernum());
			pstmt.setInt(8, pDto.getWorknum());
			pstmt.setString(9, pDto.getPwd());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProjectDto selectOneProjectByPpronum(int ppronum){
		String sql = "select * from pproject where ppronum=?";
		
		
		ProjectDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ppronum);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				pDto = new ProjectDto();
				
				pDto.setPpronum(rs.getInt("ppronum"));
				pDto.setPinitdt(rs.getString("pinitdt"));
				pDto.setPoutdt(rs.getString("poutdt"));
				pDto.setPpronm(rs.getString("ppronm"));
				pDto.setEmpno(rs.getString("empno"));
				pDto.setCareernum(rs.getInt("careernum"));
				pDto.setPwd(rs.getString("pwd"));
				pDto.setWorknum(rs.getInt("worknum"));
				pDto.setPregidt(rs.getTimestamp("Pregidt"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return pDto;
	}
	public void updatePproject(ProjectDto pDto) {
		String sql = "update pproject set PREGIDT=?, PINITDT=?, POUTDT=?, PPRONM=?, PCONTENT=?, EMPNO=?, WORKNUM=?, CAREERNUM=? where ppronum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pDto.getPpronum());
			pstmt.setTimestamp(2, pDto.getPregidt());
			pstmt.setString(3, pDto.getPinitdt());
			pstmt.setString(4, pDto.getPoutdt());
			pstmt.setString(5, pDto.getPpronm());
			pstmt.setString(6, pDto.getPcontent());
			pstmt.setString(7, pDto.getEmpno());
			pstmt.setInt(8, pDto.getWorknum());
			pstmt.setInt(9, pDto.getCareernum());
		
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProjectDto checkPassWord(String pwd, int ppronum) {
		String sql = "select *from pproject where pwd=? and ppronum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectDto pDto = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			pstmt.setInt(2, ppronum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pDto = new ProjectDto();
				
				pDto.setPpronum(rs.getInt("ppronum"));
				pDto.setPwd(rs.getString("pwd"));
				pDto.setPpronm(rs.getString("ppronm"));
				pDto.setEmpno(rs.getString("empno"));
				pDto.setPcontent(rs.getString("pcontent"));
				pDto.setPregidt(rs.getTimestamp("pregidt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pDto;
	}
	public void deletePproject(int Ppronum) {
		String sql = "delete pproject where ppronum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Ppronum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
