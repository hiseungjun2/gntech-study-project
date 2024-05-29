package biz;

import java.util.ArrayList;

import dao.buyDao;
import dto.buyDto;

public class buyBiz {

	public ArrayList<buyDto> buyList(int startRow, int pageSize) throws Exception {
		
		buyDao dao = new buyDao();
		
		ArrayList<buyDto> list = dao.buyList(startRow, pageSize);
		
		return list;
	}

	public int getBuyCount() throws Exception {
		
		buyDao dao = new buyDao();
		
		int count = dao.getBuyCount();
		
		return count;
	}

	public buyDto buyView(String num) throws Exception {
		
		buyDao dao = new buyDao();
		
		buyDto dto = dao.buyView(num);
		
		return dto;
	}

	public int buyWrite(buyDto dto) throws Exception {
	
		buyDao dao = new buyDao();
		
		int n = dao.buyWrite(dto);
		
		return n;
	}

	public ArrayList<buyDto> buyUseridList(String id, int startRow, int pageSize) throws Exception {
		
		buyDao dao = new buyDao();
		
		ArrayList<buyDto> list = dao.buyUseridList(id, startRow, pageSize);
		
		return list;
	}

	public ArrayList<buyDto> buyBuytitleList(String id, int startRow, int pageSize) throws Exception {
		
		buyDao dao = new buyDao();
		
		ArrayList<buyDto> list = dao.buyBuytitleList(id,startRow, pageSize);
		
		return list;
	}

	public int buyUseridCount(String id) throws Exception {
		
		buyDao dao = new buyDao();
		
		int n = dao.buyUseridCount(id);
		
		return n;
	}

	public int buyBuytitleCount(String id) throws Exception {
		
		buyDao dao = new buyDao();
		
		int n = dao.buyBuytitleCount(id);
		
		return n;
	}

	public int buyUpdate(int num, buyDto dto) throws Exception {
		
		buyDao dao = new buyDao();
		
		int n = dao.buyUpdate(num, dto);
		
		return n;
	
	}

	public int buyDelete(int buyid) throws Exception {
		
		buyDao dao = new buyDao();
		
		int n = dao.buyDelete(buyid);
		
		return n;
	}

	public int buyStatus(int buyid) throws Exception {
		
		buyDao dao = new buyDao();
		
		int n = dao.buyStatus(buyid);
		
		return n;
		
	}

}
