package com.project.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.common.DBManager;
import com.project.common.Dto;

public class LoginDao {
	private LoginDao(){
		
	}
	private static LoginDao instance= new LoginDao();
	
	public static LoginDao getInstance(){
		return instance;
	}
	
//	public Connection getConnection() throws Exception{
//		Connection conn=null;
//		Context initContext= new InitialContext();
//		Context envContext=(Context) initContext.lookup("java:/comp/env");
//		DataSource ds=(DataSource) envContext.lookup("jdbc/staff");
//		conn = ds.getConnection();
//		return conn;
//	}
	
	public int userCheck(String empno,String pwd,int manyn){
		int result=-1;
		String sql="select empno, empnm, manyn from emp where empno=? and pwd=? and manyn=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn= DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			pstmt.setString(2, pwd);
			pstmt.setInt(3, manyn);			
			rs= pstmt.executeQuery();
		
			if(rs.next()){
				if(rs.getInt("manyn") == 0 ){
					result = 1;
				} else{
					result = 0;
				}
			} else {
				result = -1;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}
				catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public Dto getEmp(String empno){
		Dto sDto=null;
		String sql="select * from emp where empno=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				sDto= new Dto();
				sDto.setEmpno(rs.getString("empno"));
				sDto.setPwd(rs.getString("pwd"));
				sDto.setEmpnm(rs.getString("empnm"));
				sDto.setJuminno(rs.getString("juminno"));
				sDto.setEmail(rs.getString("email"));
				sDto.setPhone(rs.getString("phone"));
				sDto.setEmp_img(rs.getString("emp_img"));
				sDto.setIndt(rs.getString("indt"));
				sDto.setOutdt(rs.getString("outdt"));
				sDto.setManyn(rs.getInt("manyn"));
				sDto.setDeptno(rs.getInt("deptno"));
				sDto.setRanknum(rs.getInt("ranknum"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sDto;
	}
	
}
