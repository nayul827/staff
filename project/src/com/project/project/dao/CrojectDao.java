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
	public List<CrojectDao> selectAllMember() {
		String sql = "select * from emp";
		List<CrojectDao> list = new ArrayList<>();
		
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
	public void insertCroject(ProjectDto pDto) {
		String sql = "insert into cproject("
				+ "cpronum, cregidate, cinitdate, coutdate, cproname, ccontent)"
				+ "values(cpronum, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pDto.getCpronum());
			pstmt.setString(2, pDto.getCregidt());
			pstmt.setString(3, pDto.getCinitdt());
			pstmt.setString(4, pDto.getCoutdt());
			pstmt.setString(5, pDto.getCpronm());
			pstmt.setString(6, pDto.getCcontent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProjectDto selectOneProjectByCpronum(int ccronum){
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
				pDto.setCregidt(rs.getString("cregidt"));
				pDto.setCinitdt(rs.getString("cinitdt"));
				pDto.setCoutdt(rs.getString("coutdt"));
				pDto.setCpronm(rs.getString("cpronm"));
				pDto.setCcontent(rs.getString("ccontent"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return pDto;
	}
	public void updateCproject(ProjectDto pDto) {
		String sql = "update cproject set cpronum=?, cregidt=?, cinitdt=?, coutdt=?, cpronm=?, ccontent=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pDto.getCpronum());
			pstmt.setString(2, pDto.getCregidt());
			pstmt.setString(3, pDto.getCinitdt());
			pstmt.setString(4, pDto.getCoutdt());
			pstmt.setString(5, pDto.getCpronm());
			pstmt.setString(6, pDto.getCcontent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
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
