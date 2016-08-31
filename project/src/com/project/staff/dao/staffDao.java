package com.project.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.common.DBManager;
import com.project.staff.dto.addrnoDto;
import com.project.staff.dto.staffDto;

public class staffDao {
	private staffDao(){
		
	}
	private static staffDao instance= new staffDao();
	
	public static staffDao getIntance(){
		if(instance==null){
			instance=new staffDao();
		}
		return instance;
	}
	
	public List<staffDto> selectAllMember(){
		String sql="select e.* , d.DEPTNM from EMP e JOIN DEPT d ON d.DEPTNO = e.DEPTNO order by e.empno DESC";
		//String sql = "select * from EMP";
		List<staffDto> list = new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			stmt= conn.createStatement();
			rs=  stmt.executeQuery(sql);
			
			while(rs.next()){
				staffDto sDto= new staffDto();
				
				sDto.setEmpno(rs.getString("empno"));
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setDeptnm(rs.getString("deptnm"));
				sDto.setWdt(rs.getString("wdt"));
				
				list.add(sDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public List<addrnoDto> selectAllAddrno(){
		String sql="select * from addrno order by no desc";
		
		List<addrnoDto> list = new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			stmt= conn.createStatement();
			rs=  stmt.executeQuery(sql);
			
			while(rs.next()){
				addrnoDto aDto= new addrnoDto();
				
				aDto.getAddrno();
				aDto.getZipcode();
				aDto.getSido();
				aDto.getSigungu();
				aDto.getDong();
				aDto.getRi();
				aDto.getBldg();
				aDto.getBungi();
				
				list.add(aDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public void insertStaff(staffDto sDto){
		String sql="insert into emp("
				+"empno,empnm,juminno,email,phone,emp_img,indt,outdt,wdt,addrno,deptno,ranknum)"
				+"values(make_empno,?,?,?,?,?,?,?,?,?,?,?)";
		
		String ssql="insert into salaryinfo("
				+"salary)"
				+"values(?)";
		
		Connection conn= null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmts=null;
		
		try {
			conn= DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmts= conn.prepareStatement(ssql);
			
		
			pstmt.setString(1, sDto.getEmpnm());
			pstmt.setString(2, sDto.getJuminno());
			pstmt.setString(3, sDto.getEmail());
			pstmt.setString(4, sDto.getPhone());
			pstmt.setString(5, sDto.getEmp_img());
			pstmt.setString(6, sDto.getIndt());
			pstmt.setString(7, sDto.getOutdt());
			pstmt.setString(8, sDto.getWdt());
			pstmt.setString(9, sDto.getAddrno());
			pstmt.setInt(10, sDto.getDeptno());
			pstmt.setInt(11, sDto.getRanknum());
			
			pstmts.setInt(1, sDto.getSalary());
			pstmt.executeUpdate();
			pstmts.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public staffDto selectOneStaffByEmpNO(String empno){
		String sql="select * from staff where empno=?";
		
		staffDto sDto=null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			rs =pstmt.executeQuery();
			if(rs.next()){
				
				sDto= new staffDto();
				
				sDto.setEmpno(rs.getString("empno"));
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setJuminno(rs.getString("juminno"));
				sDto.setEmail(rs.getString("email"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setEmp_img(rs.getString("emp_img"));
				sDto.setIndt(rs.getString("indt"));
				sDto.setOutdt(rs.getString("outdt"));
				sDto.setWdt(rs.getString("wdt"));
				sDto.setAddrno(rs.getString("addrno"));
				sDto.setDeptno(rs.getInt("deptno"));
				sDto.setRanknum(rs.getInt("ranknum"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return sDto;
	}
	public void updateStaff(staffDto sDto){
		String sql ="update emp set empnm=?, juminno=?, email=?, phone=?, emp_img=?, indt=?, outdt=?, wdt=?, addrno=? ,deptno=?, ranknum=? where empno=?" ;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sDto.getEmpnm());
			pstmt.setString(2, sDto.getJuminno());
			pstmt.setString(3, sDto.getEmail());
			pstmt.setString(4, sDto.getPhone());
			pstmt.setString(5, sDto.getEmp_img());
			pstmt.setString(6, sDto.getIndt());
			pstmt.setString(7, sDto.getOutdt());
			pstmt.setString(8, sDto.getWdt());
			pstmt.setString(9, sDto.getAddrno());
			pstmt.setInt(10, sDto.getDeptno());
			pstmt.setInt(11, sDto.getRanknum());
			pstmt.setString(12, sDto.getEmpno());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
