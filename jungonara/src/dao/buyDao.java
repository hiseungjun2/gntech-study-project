package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcTemplate;
import dto.buyDto;

public class buyDao {

	// ��ϴ� �Խñ� ��
	public int getBuyCount() throws Exception {
		// DB�� ���� �� �� ���� ���� ����
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;		// �� ���� �����ϱ� ���� ���� 
		
		try {
			pstmt = conn.prepareStatement("select count(*) from jungonara_buy");
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
		
		return x;
		
	}
	
	// ��ϴ� ����Ʈ
	public ArrayList<buyDto> buyList(int start, int end) throws Exception {
		// DB�� ���� �� �� ���� ���� ����
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<buyDto> buyList = new ArrayList<buyDto>();		// ��ü ����
		
		try {
			pstmt = conn.prepareStatement("select buy_id, buy_title, user_id, "
					+ "buy_status, buy_update from jungonara_buy "
					+ "order by buy_id desc limit ?, ?");
			// limit 4,10 �̶� 5��° ���� 10�� ������
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				buyDto buy = new buyDto();		// ��ü ����
				buy.setBuy_id(rs.getInt("buy_id"));
				buy.setBuy_title(rs.getString("buy_title"));
				buy.setUser_id(rs.getString("user_id"));
				buy.setBuy_status(rs.getString("buy_status"));
				buy.setBuy_update(rs.getString("buy_update"));
				
				buyList.add(buy);		// ArrayList �� ����
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return buyList;
	}
	
	// ��ϴ� �����׸�
	public buyDto buyView(String num) throws Exception {
		// DB�� ���� �� �� ���� ���� ����
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// ��ü ���� �� �ʱⰪ ����
		buyDto buy = null;
		
		try {
			pstmt = conn.prepareStatement("select * from jungonara_buy where buy_id = ?");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				buy = new buyDto();
				buy.setBuy_id(rs.getInt("buy_id"));
				buy.setBuy_title(rs.getString("buy_title"));
				buy.setBuy_contents(rs.getString("buy_contents"));
				buy.setBuy_type(rs.getString("buy_type"));
				buy.setBuy_subtype(rs.getString("buy_subtype"));
				buy.setBuy_update(rs.getString("buy_update"));
				buy.setBuy_created(rs.getString("buy_created"));
				buy.setBuy_trade(rs.getString("buy_trade"));
				buy.setBuy_status(rs.getString("buy_status"));
				buy.setBuy_price(rs.getString("buy_price"));
				buy.setUser_id(rs.getString("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return buy;
	}
	
	// ��ϴ� �� �ۼ�
	public int buyWrite(buyDto buy) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		int x = 0;		// ���� ���� ����
		
		try {
			// �Խñ� ��ȣ ����---------------------------
			PreparedStatement pstmt1 = conn.prepareStatement("ALTER TABLE jungonara_buy AUTO_INCREMENT=1");
		    pstmt1.executeUpdate();
		    PreparedStatement pstmt2 = conn.prepareStatement("SET @COUNT = 0");
		    pstmt2.executeUpdate();
		    PreparedStatement pstmt3 = conn.prepareStatement(
					"UPDATE jungonara_buy SET buy_id = @COUNT:=@COUNT+1");
		    pstmt3.executeUpdate();
		    //------------------------------------------------
		    
			pstmt = conn.prepareStatement("insert into jungonara_buy (buy_title, buy_contents, "
					+ "buy_type, buy_subtype, buy_update, buy_created, buy_trade, buy_status, buy_price, user_id) values "
					+ "(?, ?, ?, ?, now(), now(), ?, '�ŷ���', ?, ?) ");
			pstmt.setString(1, buy.getBuy_title());
			pstmt.setString(2, buy.getBuy_contents());
			pstmt.setString(3, buy.getBuy_type());
			pstmt.setString(4, buy.getBuy_subtype());
			pstmt.setString(5, buy.getBuy_trade());
			pstmt.setString(6, buy.getBuy_price());
			pstmt.setString(7, buy.getUser_id());
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
	
	// ��ϴ� �ۼ��� �� �˻�
	public ArrayList<buyDto> buyUseridList(String userid, int start, int end) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<buyDto> buyList = new ArrayList<buyDto>();
		
		try {
			
			pstmt = conn.prepareStatement("select buy_id, buy_title, user_id, "
					+ "buy_status, buy_update from jungonara_buy "
					+ "where user_id = ? order by buy_id desc limit ?, ?");
			// limit 4,10 �̶� 5��° ���� 10�� ������
			pstmt.setString(1, userid);
			pstmt.setInt(2, start-1);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				buyDto buy = new buyDto();
				buy.setBuy_id(rs.getInt("buy_id"));
				buy.setBuy_title(rs.getString("buy_title"));
				buy.setUser_id(rs.getString("user_id"));
				buy.setBuy_status(rs.getString("buy_status"));
				buy.setBuy_update(rs.getString("buy_update"));
				
				buyList.add(buy);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return buyList;
	}
	
	// ��ϴ� �ۼ��� �� ����
	public int buyUseridCount(String userid) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			
			pstmt = conn.prepareStatement("select count(*) from jungonara_buy where user_id = ?");
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
	
	// ��ϴ� �� ���� �� �˻�
	public ArrayList<buyDto> buyBuytitleList(String buytitle, int start, int end) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<buyDto> buyList = new ArrayList<buyDto>();
			
		try {
			
			pstmt = conn.prepareStatement("select buy_id, buy_title, user_id, "
						+ "buy_status, buy_update from jungonara_buy "
						+ "where buy_title like ? order by buy_id desc limit ?, ?");
			// limit 4,10 �̶� 5��° ���� 10�� ������
			pstmt.setString(1, "%"+buytitle+"%");
			pstmt.setInt(2, start-1);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				buyDto buy = new buyDto();
				buy.setBuy_id(rs.getInt("buy_id"));
				buy.setBuy_title(rs.getString("buy_title"));
				buy.setUser_id(rs.getString("user_id"));
				buy.setBuy_status(rs.getString("buy_status"));
				buy.setBuy_update(rs.getString("buy_update"));
					
				buyList.add(buy);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
			
		return buyList;
	}
	
	// ��ϴ� ���� �� ����
		public int buyBuytitleCount(String buytitle) throws Exception {
			Connection conn = JdbcTemplate.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int x = 0;
			
			try {
				
				pstmt = conn.prepareStatement("select count(*) from jungonara_buy where buy_title like ?");
				pstmt.setString(1, "%"+buytitle+"%");
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
	
	// �� ����
	public int buyUpdate(int buyid, buyDto buy) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		int x = 0;		// ���� ���� ����
		
		try {
			pstmt = conn.prepareStatement("update jungonara_buy set buy_title = ?, buy_contents = ?, "
					+ "buy_type = ?, buy_subtype = ?, buy_trade = ?, buy_update = now(), buy_price = ? "
					+ "where buy_id = ?");
			pstmt.setString(1, buy.getBuy_title());
			pstmt.setString(2, buy.getBuy_contents());
			pstmt.setString(3, buy.getBuy_type());
			pstmt.setString(4, buy.getBuy_subtype());
			pstmt.setString(5, buy.getBuy_trade());
			pstmt.setString(6, buy.getBuy_price());
			pstmt.setInt(7, buyid);
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
	
	// ��ϴ� �ŷ��Ϸ� 
	public int buyStatus(int buyid) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		int x = 0;		// ���� ���� ����
		
		try {
			pstmt = conn.prepareStatement("update jungonara_buy set buy_status = '�ŷ��Ϸ�' "
					+ "where buy_id = ?");
			pstmt.setInt(1, buyid);
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
	
	// ��ϴ� �� ����
	public int buyDelete(int buyid) throws Exception {
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;		// ���� ���� ����
		
		try {
			pstmt = conn.prepareStatement("delete from jungonara_buy where buy_id = ?");
			pstmt.setInt(1, buyid);
			pstmt.executeUpdate();
			
			// �Խñ� ��ȣ ����---------------------------
			PreparedStatement pstmt1 = conn.prepareStatement("ALTER TABLE jungonara_buy AUTO_INCREMENT=1");
			pstmt1.executeUpdate();
			PreparedStatement pstmt2 = conn.prepareStatement("SET @COUNT = 0");
			pstmt2.executeUpdate();
			PreparedStatement pstmt3 = conn.prepareStatement(
								"UPDATE jungonara_buy SET buy_id = @COUNT:=@COUNT+1");
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
	
}
