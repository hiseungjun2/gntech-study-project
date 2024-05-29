package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcTemplate;
import dto.sbDto;

public class sbDao {
	
	// 팝니다 게시글 수
	public int getSbCount() throws Exception {
		// DB와 연결 및 값 저장 변수 선언
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;		// 글 갯수 저장하기 위한 변수 
		
		try {
			pstmt = conn.prepareStatement("select count(*) from jungonara_sb");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);		// 게시글 수 존재하면 카운트 1 증가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		// 종료
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x;		// 글 갯수 반환
	}
	
	// 팝니다 리스트
	public ArrayList<sbDto> sbList(int start, int end) throws Exception {
		// DB와 연결 및 값 저장 변수 선언
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<sbDto> sbList = new ArrayList<sbDto>();	// 객체 생성
		
		try {
			pstmt = conn.prepareStatement("select sb_id, sb_title, user_id, "
					+ "sb_status, sb_update from jungonara_sb "
					+ "order by sb_id desc limit ?, ?");
			// limit 4, 10 이란 5번째 부터 10개 빼오기
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sbDto sb = new sbDto();		// 객체 선언
				sb.setSb_id(rs.getInt("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setUser_id(rs.getString("user_id"));
				sb.setSb_status(rs.getString("sb_status"));
				sb.setSb_update(rs.getString("sb_update"));
				
				sbList.add(sb);	// ArrayList 에 저장
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return sbList;
				
	}
	
	// 팝니다 세부항목
	public sbDto sbView(String num) throws Exception {
		// DB와 연결 및 값 저장 변수 선언
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 객체 생성 및 초기값 설정
		sbDto sb = null;
		
		try {
			pstmt = conn.prepareStatement("select * from jungonara_sb where sb_id = ?");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sb = new sbDto();
				
				sb.setSb_id(rs.getInt("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setSb_contents(rs.getString("sb_contents"));
				sb.setSb_type(rs.getString("sb_type"));
				sb.setSb_subtype(rs.getString("sb_subtype"));
				sb.setSb_update(rs.getString("sb_update"));
				sb.setSb_created(rs.getString("sb_created"));
				sb.setSb_trade(rs.getString("sb_trade"));
				sb.setSb_status(rs.getString("sb_status"));
				sb.setSb_price(rs.getString("sb_price"));
				sb.setUser_id(rs.getString("user_id"));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return sb;
	}
	
	// 팝니다 글 작성
	public int sbWrite(sbDto sb) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		int x = 0;		// 성공 여부 변수
		
		try {
			// 게시글 번호 갱신---------------------------
			PreparedStatement pstmt1 = conn.prepareStatement("ALTER TABLE jungonara_sb AUTO_INCREMENT=1");
			pstmt1.executeUpdate();
			PreparedStatement pstmt2 = conn.prepareStatement("SET @COUNT = 0");
			pstmt2.executeUpdate();
			PreparedStatement pstmt3 = conn.prepareStatement(
								"UPDATE jungonara_sb SET sb_id = @COUNT:=@COUNT+1");
			pstmt3.executeUpdate();
			// ------------------------------------------------
			
			pstmt = conn.prepareStatement("insert into jungonara_sb (sb_title, sb_contents, "
					+ "sb_type, sb_subtype, sb_update, sb_created, sb_trade, sb_status,"
					+ "sb_price, user_id) values (?, ?, ?, ?, now(), now(), ?, '거래중', ?, ?)");
			pstmt.setString(1, sb.getSb_title());
			pstmt.setString(2, sb.getSb_contents());
			pstmt.setString(3, sb.getSb_type());
			pstmt.setString(4, sb.getSb_subtype());
			pstmt.setString(5, sb.getSb_trade());
			pstmt.setString(6, sb.getSb_price());
			pstmt.setString(7, sb.getUser_id());
			pstmt.executeUpdate();
			
			x = 1;		// 글쓰기 성공
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x;		// 성공 여부 리턴
	}
	
	// 팝니다 작성자 글 검색
	public ArrayList<sbDto>sbUseridList(String userid, int start, int end) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<sbDto> sbList = new ArrayList<sbDto>();
		
		try {
			pstmt = conn.prepareStatement("select sb_id, sb_title, user_id, "
					+ "sb_status, sb_update from jungonara_sb "
					+ "where user_id =  ? order by sb_id desc limit ?, ?");
			// limit 4,10 이란 5번째부터 10개 빼오기
			pstmt.setString(1, userid);
			pstmt.setInt(2, start-1);
			pstmt.setInt(3,  end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sbDto sb = new sbDto();
				sb.setSb_id(rs.getInt("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setUser_id(rs.getString("user_id"));
				sb.setSb_status(rs.getString("sb_status"));
				sb.setSb_update(rs.getString("sb_update"));
				
				sbList.add(sb);	// 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return sbList;
	}
	
	// 팝니다 작성자 글 갯수
		public int sbUseridCount(String userid) throws Exception {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int x = 0;
			
			try {
				
				pstmt = conn.prepareStatement("select count(*) from jungonara_sb where user_id = ?");
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					x = rs.getInt(1);		// 게시글 수 존재하면 카운트 1 증가
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
	
	// 팝니다 제목 글 검색
	public ArrayList<sbDto> sbSbtitleList(String sbtitle, int start, int end) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<sbDto> sbList = new ArrayList<sbDto>();
		
		try {
			pstmt = conn.prepareStatement("select sb_id, sb_title, user_id, "
					+ "sb_status, sb_update from jungonara_sb "
					+ "where sb_title like ? order by sb_id desc limit ?, ?");
			// limit 4,10 이란 5번째부터 10개 빼오기
			pstmt.setString(1, "%"+sbtitle+"%");
			pstmt.setInt(2, start-1);
			pstmt.setInt(3,  end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sbDto sb = new sbDto();
				sb.setSb_id(rs.getInt("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setUser_id(rs.getString("user_id"));
				sb.setSb_status(rs.getString("sb_status"));
				sb.setSb_update(rs.getString("sb_update"));
				
				sbList.add(sb);	// 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return sbList;
	}
	// 팝니다 제목 글 갯수
	public int sbSbtitleCount(String sbtitle) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		int x = 0;
				
		try {
					
			pstmt = conn.prepareStatement("select count(*) from jungonara_sb where sb_title like ?");
			pstmt.setString(1, "%"+sbtitle+"%");
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				x = rs.getInt(1);		// 게시글 수 존재하면 카운트 1 증가
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
	
	
	// 팝니다 글 삭제
	public int sbDelete(int sbid) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;		// 성공 여부 변수
		
		try {
			pstmt = conn.prepareStatement("delete from jungonara_sb where sb_id = ?");
			pstmt.setInt(1, sbid);
			pstmt.executeUpdate();
			
			// 게시글 번호 갱신---------------------------
			PreparedStatement pstmt1 = conn.prepareStatement("ALTER TABLE jungonara_sb AUTO_INCREMENT=1");
			pstmt1.executeUpdate();
			PreparedStatement pstmt2 = conn.prepareStatement("SET @COUNT = 0");
			pstmt2.executeUpdate();
			PreparedStatement pstmt3 = conn.prepareStatement(
								"UPDATE jungonara_sb SET sb_id = @COUNT:=@COUNT+1");
			pstmt3.executeUpdate();
			//------------------------------------------------
			
			x = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x;
	}
	
	// 팝니다 글 수정
	public int sbUpdate(int sbid, sbDto sb) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		int x = 0;		// 성공 여부 변수
		
		try {
			pstmt = conn.prepareStatement("update jungonara_sb set sb_title = ?, sb_contents = ?, "
					+ "sb_type = ?, sb_subtype = ?, sb_trade = ?, sb_update = now(), sb_price = ? "
					+ "where sb_id = ?");
			pstmt.setString(1, sb.getSb_title());
			pstmt.setString(2, sb.getSb_contents());
			pstmt.setString(3, sb.getSb_type());
			pstmt.setString(4, sb.getSb_subtype());
			pstmt.setString(5, sb.getSb_trade());
			pstmt.setString(6, sb.getSb_price());
			pstmt.setInt(7, sbid);
			pstmt.executeUpdate();
			
			x = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x ;
	}
	
	// 팝니다 거래완료 
		public int sbStatus(int sbid) throws Exception {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			int x = 0;		// 성공 여부 변수
			
			try {
				pstmt = conn.prepareStatement("update jungonara_sb set sb_status = '거래완료' "
						+ "where sb_id = ?");
				pstmt.setInt(1, sbid);
				pstmt.executeUpdate();
				
				x = 1;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
				JdbcTemplate.close(conn);
			}
			
			return x ;
		}
}
