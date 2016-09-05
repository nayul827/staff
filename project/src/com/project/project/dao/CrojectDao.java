package com.project.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.common.DBManager;
import com.project.project.dto.ProjectDto;

public class CrojectDao {
	private CrojectDao() {
		
	}
	private static CrojectDao instance = new CrojectDao();
	
	public static CrojectDao getInstance() {
		if(instance == null) {
			instance = new CrojectDao();
		}
		return instance;
	}
	public List<ProjectDto> selectAllMember() {
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
				
				pDto.setCpronum(rs.getInt("cpronum"));
				pDto.setEmpno(rs.getString("empno"));
				pDto.setCpronm(rs.getString("cpronm"));
				pDto.setPwd(rs.getString("pwd"));
				pDto.setCregidt(rs.getTimestamp("cregidt"));
				pDto.setCcontent(rs.getString("ccontent"));
				
				list.add(pDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public void insertCroject(ProjectDto pDto) {
		String sql = "insert into cpro("
				+ "cpronum, cregidate, cinitdate, coutdate, cproname, ccontent, pwd)"
				+ "values(cpro_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pDto.getCpronum());
			pstmt.setTimestamp(2, pDto.getCregidt());
			pstmt.setString(3, pDto.getCinitdt());
			pstmt.setString(4, pDto.getCoutdt());
			pstmt.setString(5, pDto.getCpronm());
			pstmt.setString(6, pDto.getCcontent());
			pstmt.setString(7, pDto.getPwd());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProjectDto selectOneProjectByCpronum(int cpronum){
		String sql = "select * from cproject where cpronum=?";
		
		ProjectDto pDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cpronum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pDto = new ProjectDto();
				
				pDto.setCpronum(rs.getInt("cpronum"));
				pDto.setCregidt(rs.getTimestamp("cregidt"));
				pDto.setCinitdt(rs.getString("cinitdt"));
				pDto.setCoutdt(rs.getString("coutdt"));
				pDto.setCpronm(rs.getString("cpronm"));
				pDto.setCcontent(rs.getString("ccontent"));
				pDto.setPwd(rs.getString("pwd"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return pDto;
	}
	public void updateCproject(ProjectDto pDto) {
		String sql = "update cproject set pwd=?, cpronm=?, ccontent=? where cpronum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pDto.getCpronum());
			pstmt.setString(2, pDto.getPwd());
			pstmt.setString(3, pDto.getCpronm());
			pstmt.setString(4, pDto.getCcontent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProjectDto checkPassWord(String pwd, int cpronum) {
		String sql = "select * from cpro where pwd=? and cpronum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectDto pDto = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			pstmt.setInt(2, cpronum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pDto = new ProjectDto();
				
				pDto.setCpronum(rs.getInt("cpronum"));
				pDto.setPwd(rs.getString("pwd"));
				pDto.setCpronm(rs.getString("cpronm"));
				pDto.setEmpno(rs.getString("empno"));
				pDto.setCcontent(rs.getString("ccontent"));
				pDto.setCregidt(rs.getTimestamp("cregidt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pDto;
	}
	public void deleteCproject(int Cpronum) {
		String sql = "delet cproject where cpronum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Cpronum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
