package com.project.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.common.DBManager;
import com.project.staff.dto.addrnoDto;
import com.project.staff.dto.careerDto;
import com.project.staff.dto.degreeDto;
import com.project.staff.dto.licenseDto;
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
	public int totalCount(){
		int cnt=0;
		String sql="select count(empno) cnt from emp";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBManager.getConnection();
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				cnt=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return cnt;
	}
	public List<staffDto> selectAllMember(int start,int end){
		String sql="select empno, empnm, ranknm,wdt FROM (SELECT ROWNUM r,a.* from (SELECT e.*, d.ranknm FROM EMP e JOIN rank d ON d.ranknum = e.ranknum order by e.empno DESC )a) WHERE r BETWEEN ? AND ?";
		//String sql = "select * from EMP";
		List<staffDto> list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=  pstmt.executeQuery();
			
			while(rs.next()){
				staffDto sDto= new staffDto();
				
				sDto.setEmpno(rs.getString("empno"));
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setRanknm(rs.getString("ranknm"));
				sDto.setWdt(rs.getString("wdt"));
				
				
				list.add(sDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
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
	public int insertStaff(staffDto sDto, String empno){
		int result = -1;
		System.out.println(sDto.toString());
		String sql="insert into emp("
				+"empno,empnm,juminno,email,phone,emp_img,indt,outdt,wdt,addrno,deptno,ranknum)"
				+"values(make_empno,?,?,?,?,?,?,?,?,?,?,?)";
		
		String ssql="insert into salaryinfo("
				+"empno, "
				+"salary)"
				+"values(?,?)";
		
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
			pstmt.setString(6, sDto.getIndt().replace("/", "").trim());
			pstmt.setString(7, sDto.getOutdt().replace("/", "").trim());
			pstmt.setString(8, sDto.getWdt().replace("/", "").trim());
			pstmt.setString(9, sDto.getAddrno());
			pstmt.setInt(10, sDto.getDeptno());
			pstmt.setInt(11, sDto.getRanknum());
			result = pstmt.executeUpdate();
			
			pstmts.setString(1, empno);
			pstmts.setInt(2, sDto.getSalary());
			pstmts.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	public staffDto selectOneEmpByEmpNO(String empno){
		String sql="select * from emp where empno=?";
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
			DBManager.close(conn, pstmt,rs);
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
	public String SelectInsertEmpno(){
		String sql = "select make_empno e from dual";
		String result=null;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			if(rs.next()){
				result= rs.getString("e");
			}
		}catch(Exception e){
			
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
//-----------------------------자격증 다오--------------------------
	public List<licenseDto> selectAllLicense(){
		String sql="select * from license order by no desc";
		
		List<licenseDto> list = new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			stmt= conn.createStatement();
			rs=  stmt.executeQuery(sql);
			
			while(rs.next()){
				licenseDto lDto= new licenseDto();
				
				lDto.setLicensenum((rs.getString("licensenum")));
				lDto.setLicensenm(rs.getString("licensenm"));
				lDto.setGetdt(rs.getString("getdt"));
				lDto.setLicenseoffice(rs.getString("licenseoffice"));
				
				list.add(lDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int insertLicense(licenseDto lDto){
		int result=-1;
		String sql="insert into license ("
				+"licensenum,licensenm,getdt,licenseoffice,empno)"
				+"values(license_licensenum_seq.nextval,?,?,?,?)";
		
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn= DBManager.getConnection();	
				pstmt= conn.prepareStatement(sql.toString());
			
				pstmt.setString(1, lDto.getLicensenm());
				pstmt.setString(2, lDto.getGetdt());
				pstmt.setString(3, lDto.getLicenseoffice());
				pstmt.setString(4, lDto.getEmpno());
				
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
			return result;
	}
	public int deleteLicense(int licensenum){
		int result=-1;
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		StringBuilder sql= new StringBuilder();
		sql.append("delete from license ");
		sql.append("where licensenum=? ");
		
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, licensenum);
			result= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

		return result;	
	}
	public int lastInsert(){
		licenseDto llDto = new licenseDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int lastSeq= 0;
		
		StringBuilder lastsql= new StringBuilder();
		lastsql.append("select license_licensenum_seq.currval as lastseq from dual");
		
		
		try {
			conn= DBManager.getConnection();
			pstmt=conn.prepareStatement(lastsql.toString());

			rs = pstmt.executeQuery();
			if(rs.next()){
				lastSeq= rs.getInt("lastseq");
			}
			if(rs.next()){
				llDto=new licenseDto();
				llDto.setLicensenum(rs.getString("licensenum"));
				llDto.setLicensenm(rs.getString("licensenm"));
				llDto.setGetdt(rs.getString("getdt"));
				llDto.setLicenseoffice(rs.getString("licenseoffice"));
				System.out.println(llDto.getLicensenum());
				System.out.println(llDto.getLicensenm());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lastSeq;
	}
	
	public licenseDto lastInsertt(int lastSeq){
		licenseDto lDto = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		

		StringBuilder sql= new StringBuilder();
		sql.append("select licensenum,licensenm,getdt,licenseoffice from license where licensenum=?");
		
		try {
			conn= DBManager.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, lastSeq);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				lDto=new licenseDto();
				lDto.setLicensenum(rs.getString("licensenum"));
				lDto.setLicensenm(rs.getString("licensenm"));
				lDto.setGetdt(rs.getString("getdt"));
				lDto.setLicenseoffice(rs.getString("licenseoffice"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lDto;
	}
// ----------------------------- 경력 다오-------------------------------
	public List<careerDto> selectAllCareer(){
		String sql="select * from career order by no desc";
		
		List<careerDto> list = new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			stmt= conn.createStatement();
			rs=  stmt.executeQuery(sql);
			
			while(rs.next()){
				careerDto cDto = new careerDto();
				
 				cDto.setCareernum((rs.getInt("careernum")));
				cDto.setFirmnm(rs.getString("firmnm"));
				cDto.setEnterdt(rs.getString("enterdt"));
				cDto.setOuterdt(rs.getString("outerdt"));
				cDto.setPosition(rs.getString("position"));
				cDto.setWorknm(rs.getString("worknm"));
				
				list.add(cDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int insertCareer(careerDto dDto){
		System.out.println(dDto.toString());
		int result=-1;
		String sql="insert into career("
				+"careernum,firmnm,enterdt,outerdt,position,worknm,empno)"
				+"values(career_careernum_seq.nextval,?,?,?,?,?,?)";
		
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn= DBManager.getConnection();	
				pstmt= conn.prepareStatement(sql.toString());
			
				
				pstmt.setString(1, dDto.getFirmnm());
				pstmt.setString(2, dDto.getEnterdt());
				pstmt.setString(3, dDto.getOuterdt());
				pstmt.setString(4, dDto.getPosition());
				pstmt.setString(5, dDto.getWorknm());
				pstmt.setString(6, dDto.getEmpno());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
			return result;
	}
	
	public int deleteCareer(int careernum){
		int result=-1;
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		StringBuilder sql= new StringBuilder();
		sql.append("delete from career");
		sql.append("where careernum=?");
		
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, careernum);
			result= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

		return result;	
	}
	public degreeDto lastInsertCareer(){
		degreeDto dDto = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int lastSeq= 0;
		
		StringBuilder lastsql= new StringBuilder();
		lastsql.append("select degree_degreenum_seq.currval as lastseq from dual");
		
		StringBuilder sql= new StringBuilder();
		sql.append("select * from degree where degreenum=?");
		
		try {
			conn= DBManager.getConnection();
			pstmt=conn.prepareStatement(lastsql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				lastSeq= rs.getInt("lastseq");
			}
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setInt(1, lastSeq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dDto=new degreeDto();
				
				dDto.setDegreenum(Integer.parseInt(rs.getString("degreenum")));
				dDto.setFinaldegree(rs.getString("finaldegree"));
				dDto.setMajor(rs.getString("collegenm"));
				dDto.setEntrandt(rs.getString("major"));
				dDto.setGradudt(rs.getString("gradudt"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dDto;
	}
	
//------------------------------ 학력 다오------------------------------
	public List<degreeDto> selectAllDegree(){
		String sql="select * from degree order by no desc";
		
		List<degreeDto> list = new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			stmt= conn.createStatement();
			rs=  stmt.executeQuery(sql);
			
			while(rs.next()){
				degreeDto dDto= new degreeDto();
				
				dDto.setDegreenum((rs.getInt("licensenum")));
				dDto.setFinaldegree(rs.getString("finaldegree"));
				dDto.setCollegenm(rs.getString("collegenm"));
				dDto.setMajor(rs.getString("major"));
				dDto.setEntrandt(rs.getString("entrandt"));
				dDto.setGradudt(rs.getString("gradudt"));
				
				
				list.add(dDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public int insertDegree(degreeDto dDto){
		System.out.println(dDto.toString());
		int result=-1;
		String sql="insert into degree ("
				+"degreenum,finaldegree,collegenm,major,entrandt,gradudt,empno)"
				+"values(degree_degreenum_seq.nextval,?,?,?,?,?,?)";
		
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn= DBManager.getConnection();	
				pstmt= conn.prepareStatement(sql.toString());
			
				
				pstmt.setString(1, dDto.getFinaldegree());
				pstmt.setString(2, dDto.getCollegenm());
				pstmt.setString(3, dDto.getMajor());
				pstmt.setString(4, dDto.getGradudt());
				pstmt.setString(5, dDto.getGradudt());
				pstmt.setString(6, dDto.getEmpno());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
			return result;
	}
	
	public int deleteDegree(int degreenum){
		int result=-1;
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		StringBuilder sql= new StringBuilder();
		sql.append("delete from degree");
		sql.append("where degreenum=?");
		
		try {
			conn = DBManager.getConnection();
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, degreenum);
			result= pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

		return result;	
	}
	public degreeDto lastInsertDegree(){
		degreeDto dDto = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int lastSeq= 0;
		
		StringBuilder lastsql= new StringBuilder();
		lastsql.append("select degree_degreenum_seq.currval as lastseq from dual");
		
		StringBuilder sql= new StringBuilder();
		sql.append("select * from degree where degreenum=?");
		
		try {
			conn= DBManager.getConnection();
			pstmt=conn.prepareStatement(lastsql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				lastSeq= rs.getInt("lastseq");
			}
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setInt(1, lastSeq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dDto=new degreeDto();
				
				dDto.setDegreenum(Integer.parseInt(rs.getString("degreenum")));
				dDto.setFinaldegree(rs.getString("finaldegree"));
				dDto.setMajor(rs.getString("collegenm"));
				dDto.setEntrandt(rs.getString("major"));
				dDto.setGradudt(rs.getString("gradudt"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dDto;
		
	}
}