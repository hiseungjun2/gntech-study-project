package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcTemplate;
import dto.sbDto;

public class sbDao {
	
	// �˴ϴ� �Խñ� ��
	public int getSbCount() throws Exception {
		// DB�� ���� �� �� ���� ���� ����
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;		// �� ���� �����ϱ� ���� ���� 
		
		try {
			pstmt = conn.prepareStatement("select count(*) from jungonara_sb");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);		// �Խñ� �� �����ϸ� ī��Ʈ 1 ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		// ����
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x;		// �� ���� ��ȯ
	}
	
	// �˴ϴ� ����Ʈ
	public ArrayList<sbDto> sbList(int start, int end) throws Exception {
		// DB�� ���� �� �� ���� ���� ����
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<sbDto> sbList = new ArrayList<sbDto>();	// ��ü ����
		
		try {
			pstmt = conn.prepareStatement("select sb_id, sb_title, user_id, "
					+ "sb_status, sb_update from jungonara_sb "
					+ "order by sb_id desc limit ?, ?");
			// limit 4, 10 �̶� 5��° ���� 10�� ������
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sbDto sb = new sbDto();		// ��ü ����
				sb.setSb_id(rs.getInt("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setUser_id(rs.getString("user_id"));
				sb.setSb_status(rs.getString("sb_status"));
				sb.setSb_update(rs.getString("sb_update"));
				
				sbList.add(sb);	// ArrayList �� ����
				
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
	
	// �˴ϴ� �����׸�
	public sbDto sbView(String num) throws Exception {
		// DB�� ���� �� �� ���� ���� ����
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// ��ü ���� �� �ʱⰪ ����
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
	
	// �˴ϴ� �� �ۼ�
	public int sbWrite(sbDto sb) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		int x = 0;		// ���� ���� ����
		
		try {
			// �Խñ� ��ȣ ����---------------------------
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
					+ "sb_price, user_id) values (?, ?, ?, ?, now(), now(), ?, '�ŷ���', ?, ?)");
			pstmt.setString(1, sb.getSb_title());
			pstmt.setString(2, sb.getSb_contents());
			pstmt.setString(3, sb.getSb_type());
			pstmt.setString(4, sb.getSb_subtype());
			pstmt.setString(5, sb.getSb_trade());
			pstmt.setString(6, sb.getSb_price());
			pstmt.setString(7, sb.getUser_id());
			pstmt.executeUpdate();
			
			x = 1;		// �۾��� ����
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return x;		// ���� ���� ����
	}
	
	// �˴ϴ� �ۼ��� �� �˻�
	public ArrayList<sbDto>sbUseridList(String userid, int start, int end) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<sbDto> sbList = new ArrayList<sbDto>();
		
		try {
			pstmt = conn.prepareStatement("select sb_id, sb_title, user_id, "
					+ "sb_status, sb_update from jungonara_sb "
					+ "where user_id =  ? order by sb_id desc limit ?, ?");
			// limit 4,10 �̶� 5��°���� 10�� ������
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
				
				sbList.add(sb);	// �߰�
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
	
	// �˴ϴ� �ۼ��� �� ����
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
					x = rs.getInt(1);		// �Խñ� �� �����ϸ� ī��Ʈ 1 ����
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
	
	// �˴ϴ� ���� �� �˻�
	public ArrayList<sbDto> sbSbtitleList(String sbtitle, int start, int end) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<sbDto> sbList = new ArrayList<sbDto>();
		
		try {
			pstmt = conn.prepareStatement("select sb_id, sb_title, user_id, "
					+ "sb_status, sb_update from jungonara_sb "
					+ "where sb_title like ? order by sb_id desc limit ?, ?");
			// limit 4,10 �̶� 5��°���� 10�� ������
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
				
				sbList.add(sb);	// �߰�
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
	// �˴ϴ� ���� �� ����
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
				x = rs.getInt(1);		// �Խñ� �� �����ϸ� ī��Ʈ 1 ����
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
	
	
	// �˴ϴ� �� ����
	public int sbDelete(int sbid) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;		// ���� ���� ����
		
		try {
			pstmt = conn.prepareStatement("delete from jungonara_sb where sb_id = ?");
			pstmt.setInt(1, sbid);
			pstmt.executeUpdate();
			
			// �Խñ� ��ȣ ����---------------------------
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
	
	// �˴ϴ� �� ����
	public int sbUpdate(int sbid, sbDto sb) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		int x = 0;		// ���� ���� ����
		
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
	
	// �˴ϴ� �ŷ��Ϸ� 
		public int sbStatus(int sbid) throws Exception {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			int x = 0;		// ���� ���� ����
			
			try {
				pstmt = conn.prepareStatement("update jungonara_sb set sb_status = '�ŷ��Ϸ�' "
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
