package biz;

import dao.userDao;
import dto.userDto;

public class userBiz {

	public int insertUser(userDto dto) throws Exception {
		userDao dao = new userDao();
		
		int n = dao.insertUser(dto);
		
		return n;
	}

	public int checkUser(String email, String pw) throws Exception {
		userDao dao = new userDao();
		
		int n = dao.checkUser(email, pw);
		
		return n;
	}

	public String openUserid(String email) throws Exception {
	
		userDao dao = new userDao();
		
		String id = dao.openUserid(email);
		
		return id;
	}

}
