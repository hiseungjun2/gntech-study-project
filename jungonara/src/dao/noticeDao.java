// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   noticeDao.java

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcTemplate;
import dto.noticeDto;

public class noticeDao
{
	
	
	private static noticeDao instance = new noticeDao();
	
	public static noticeDao getInstance() {
		return instance;
	}
	
	// 공지사항 갯수
	public int getNoticeCount() throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			pstmt = conn.prepareStatement("select count(*) from jungonara_notice");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 x = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x;
	}
	
	// 공지사항 리스트 
	public ArrayList<noticeDto> noticeList(int start, int end) throws Exception {
		
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<noticeDto> list = new ArrayList<noticeDto>();
		
		try {
			pstmt = conn.prepareStatement("select notice_id, notice_title, notice_date from jungonara_notice order by notice_id desc limit ?, ?");
			// limit 4,10 이란 5번째 부터 10개 빼오기
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				noticeDto notice = new noticeDto();
				
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_date(rs.getString("notice_date"));
				
				list.add(notice);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return list;
	
	}
	
	// 공지사항 세부보기
	public noticeDto noticeView(String num) throws Exception {
		
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		noticeDto notice = null;
		
		try {
			pstmt = conn.prepareStatement("select * from jungonara_notice where notice_id = ?");
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				notice = new noticeDto();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_contents(rs.getString("notice_contents"));
				notice.setNotice_date(rs.getString("notice_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return notice;
	
	}

	
	
}
