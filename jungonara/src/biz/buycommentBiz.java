package biz;

import java.util.ArrayList;

import dao.buycommentDao;
import dto.buycommentDto;

public class buycommentBiz {

	public void buyInsertComment(buycommentDto dto) throws Exception {
		
		buycommentDao dao = new buycommentDao();
		
		dao.buyInsertComment(dto);
	
	}

	public ArrayList<buycommentDto> buyListComment(String buy_id) throws Exception {
		
		buycommentDao dao = new buycommentDao();
		
		ArrayList<buycommentDto> list = dao.buyListComment(buy_id);
		
		return list;
	}

}
