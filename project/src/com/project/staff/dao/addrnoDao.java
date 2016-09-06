package com.project.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.common.DBManager;
import com.project.staff.dto.addrnoDto;
import com.project.staff.dto.degreeDto;

public class addrnoDao {
	public addrnoDao(){
		
	}
	private static addrnoDao instance = new addrnoDao();
	
	public static addrnoDao getInstance(){
		return instance;
	}
	public List<addrnoDto> selectAllAddr(String search){
		StringBuilder sql = new StringBuilder();
		sql.append("select							");
		sql.append("addrno							");
		sql.append(",zipcode						");
		sql.append(",sido							");
		sql.append(",sigungu						");
		sql.append(",dong							");
		sql.append(",NVL(ri,' ') as ri				");
		sql.append(",NVL(bldg,' ') as bldg			");
		sql.append(",NVL(bungi,' ') as bungi		");
		sql.append("from							");
		sql.append("addr							");
		sql.append("where							");
		sql.append("dong like ?||'%'				");
	
		List<addrnoDto> list= new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			conn= DBManager.getConnection();
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, search);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				addrnoDto aDto= new addrnoDto();
				
				aDto.setAddrno(rs.getInt("addrno"));
				aDto.setZipcode(rs.getString("zipcode"));
				aDto.setSido(rs.getString("sido"));
				aDto.setSigungu(rs.getString("sigungu"));
				aDto.setDong(rs.getString("dong"));
				aDto.setRi(rs.getString("ri"));
				aDto.setBldg(rs.getString("bldg"));
				aDto.setBungi(rs.getString("bungi"));
			
				list.add(aDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public int insertAddr(addrnoDto aDto){
		System.out.println(aDto.toString());
		int result=-1;
		String sql="insert into addr ("
				+"addrno,zipcode,sido,sigungu,dong,ri,bldg,bungi)"
				+"values(adrr_addrno_seq.nextval,?,?,?,?,?,?,?)";
		
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn= DBManager.getConnection();	
				pstmt= conn.prepareStatement(sql.toString());
			
				
				pstmt.setString(1, aDto.getZipcode());
				pstmt.setString(2, aDto.getSido());
				pstmt.setString(3, aDto.getSigungu());
				pstmt.setString(4, aDto.getDong());
				pstmt.setString(5, aDto.getRi());
				pstmt.setString(6, aDto.getBldg());
				pstmt.setString(7, aDto.getBungi());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
			return result;
	}
}
