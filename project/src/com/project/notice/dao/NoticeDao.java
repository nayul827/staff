package com.project.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.common.DBManager;
import com.project.notice.dto.NoticeDto;

public class NoticeDao {
	private NoticeDao(){
		
	}
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance(){
		if(instance==null){
			instance= new NoticeDao();
		}
		return instance;
	}
	
	public List<NoticeDto> selectAllNotice(){
		String sql= "select * from notice order by noticenum desc";
		
		List<NoticeDto> list= new ArrayList<>();
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				NoticeDto nDto= new NoticeDto();
				
				nDto.setNoticenum(rs.getInt("noticenum"));
				nDto.setPass(rs.getString("pass"));
				nDto.setTitle(rs.getString("title"));
				nDto.setWriter(rs.getString("writer"));
				nDto.setContent(rs.getString("content"));
				nDto.setWritedate(rs.getTimestamp("writedate"));
				nDto.setHits(rs.getInt("hits"));
				nDto.setEmpno(rs.getString("empno"));
				
				list.add(nDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt,rs);
		}
		
		return list;
	}
	
	public void insertNotice(NoticeDto nDto){
		String sql="insert into notice("
				+"noticenum,writer,pass,title,content,empno)"
				+"values(notice_seq.nextval,?,?,?,?,?)";
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nDto.getWriter());
			pstmt.setString(2, nDto.getPass());
			pstmt.setString(3, nDto.getTitle());
			pstmt.setString(4, nDto.getContent());
			pstmt.setString(5, nDto.getEmpno());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void updateReadCount(int noticenum){
		String sql="update notice set readcount=readcount+1 where noticenum=?";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticenum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public NoticeDto selectOneNoticeByNoticeNum(int noticenum){
		String sql="select * from notice where noticenum=?";
		
		NoticeDto nDto=null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticenum);
			
			rs =pstmt.executeQuery();
			
			if(rs.next()){
				nDto=new NoticeDto();
				
				nDto.setNoticenum(rs.getInt("noticenum"));
				nDto.setPass(rs.getString("pass"));
				nDto.setTitle(rs.getString("title"));
				nDto.setWriter(rs.getString("writer"));
				nDto.setContent(rs.getString("content"));
				nDto.setWritedate(rs.getTimestamp("writedate"));
				nDto.setHits(rs.getInt("hits"));
				nDto.setEmpno(rs.getString("empno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return nDto;
	}
	public void updateNotice(NoticeDto nDto){
		String sql="update Notice set writer=?, pass=? ,title=? ,content=? where noticenum=?";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nDto.getWriter());
			pstmt.setString(2, nDto.getPass());
			pstmt.setString(3, nDto.getTitle());
			pstmt.setString(4, nDto.getContent());
			pstmt.setInt(5, nDto.getNoticenum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public NoticeDto checkPassWord(String pass,int noticenum){
		String sql="select * from notice where pass=? and noticenum=?";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		NoticeDto nDto=null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pass);
			pstmt.setInt(2, noticenum);
			
			rs =pstmt.executeQuery();
			
			if(rs.next()){
				nDto=new NoticeDto();
				
				nDto.setNoticenum(rs.getInt("noticenum"));
				nDto.setPass(rs.getString("pass"));
				nDto.setTitle(rs.getString("title"));
				nDto.setWriter(rs.getString("writer"));
				nDto.setContent(rs.getString("content"));
				nDto.setWritedate(rs.getTimestamp("writedate"));
				nDto.setHits(rs.getInt("hits"));
				nDto.setEmpno(rs.getString("empno"));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nDto;
	}
	public void deleteNotice(int noticenum){
		String sql="delete notice where noticenum=?";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticenum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
