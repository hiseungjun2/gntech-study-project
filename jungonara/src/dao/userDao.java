package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JdbcTemplate;
import dto.userDto;

public class userDao
{

 
    
    private static userDao instance = new userDao();
    
    public static userDao getInstance() {
        return instance;
    }
    
    public static final int MEMBER_NONEXISTENT = 0;
    public static final int MEMBER_EXISTENT = 1;
    public static final int MEMBER_JOIN_FAIL = 0;
    public static final int MEMBER_JOIN_SUCCESS = 1;
    public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
    public static final int MEMBER_LOGIN_SUCCESS = 1;
    public static final int MEMBER_LOGIN_IS_NOT = -1;
    
    // ȸ�� ����
    public int insertUser(userDto dto) throws Exception {
        Connection conn = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        int x = 0;		// ȸ������ ���� ���� ����
        
        try {
            pstmt = conn.prepareStatement("insert into jungonara_user values (?,?,?,?)");
            pstmt.setString(1, dto.getUser_id());
            pstmt.setString(2, dto.getUser_email());
            pstmt.setString(3, dto.getUser_pw());
            pstmt.setString(4, dto.getUser_name());
            pstmt.executeUpdate();
            x = 1;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
        }
        return x;
    }

    // ȸ�� �α���
    public int checkUser(String email, String pw) throws Exception {
        Connection conn = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int x = -1;	// �α��� ���� ���� ����
        
        try {
            pstmt = conn.prepareStatement("select user_pw from jungonara_user where user_email = ?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                String dbuser_pw = rs.getString("user_pw");
                if(pw.equals(dbuser_pw)) 
                	x = 1; // �α��� ����
                else
                    x = 0; // ��й�ȣ ����ġ
            } else {
            	x = -1;	// ��� ����ġ
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
        }
        return x;
    }
    
    // ���� �����ϱ� ���� ���̵� �ҷ�����
    public String openUserid(String email) throws Exception {
    	Connection conn = JdbcTemplate.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String id = null;
    	
    	try {
            pstmt = conn.prepareStatement("select user_id from jungonara_user where user_email = ?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	id = rs.getString("user_id");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
        }
    	
    	return id;
    }
}
