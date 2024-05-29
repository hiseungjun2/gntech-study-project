package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcTemplate;
import dto.buycommentDto;

public class buycommentDao {
	
	// »ð´Ï´Ù ´ñ±Û Ãß°¡
	public void buyInsertComment(buycommentDto dto) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement("insert into jungonara_buycomment (comment_content, comment_date, "
					+ "user_id, buy_id) values (?, now(), ?, ?)");
			pstmt.setString(1, dto.getComment_content());
			pstmt.setString(2, dto.getUser_id());
			pstmt.setString(3, dto.getBuy_id());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
	}
	
	// »ð´Ï´Ù ´ñ±Û Á¶È¸
	public ArrayList<buycommentDto> buyListComment(String buy_id) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<buycommentDto> list = new ArrayList<>();
		
		buycommentDto dto = null;
		
		try {
			
			pstmt = conn.prepareStatement("select comment_content, comment_date, user_id "
					+ "from jungonara_buycomment where buy_id = ? order by comment_date");
			
			pstmt.setString(1, buy_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new buycommentDto();
				dto.setComment_content(rs.getString("comment_content"));
				dto.setComment_date(rs.getString("comment_date"));
				dto.setUser_id(rs.getString("user_id"));
				
				list.add(dto);
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
}
