package biz;

import java.util.ArrayList;

import dao.noticeDao;
import dto.noticeDto;

public class noticeBiz {

	public ArrayList<noticeDto> noticeList(int start, int end) throws Exception {
		
		noticeDao dao = new noticeDao();
		
		ArrayList<noticeDto> list = dao.noticeList(start, end);
		
		return list;
	}

	public int getNoticeCount() throws Exception {
		noticeDao dao = new noticeDao();
		
		int count = dao.getNoticeCount();
		
		return count;
	}

	public noticeDto noticeView(String num) throws Exception {
		noticeDao dao = new noticeDao();
		
		noticeDto dto = dao.noticeView(num);
		
		return dto;
	}

}
