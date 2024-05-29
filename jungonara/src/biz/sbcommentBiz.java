package biz;

import java.util.ArrayList;

import dao.sbcommentDao;
import dto.sbcommentDto;

public class sbcommentBiz {

	public void sbInsertComment(sbcommentDto dto) throws Exception {
		
		sbcommentDao dao = new sbcommentDao();
		
		dao.sbInsertComment(dto);
		
	}
	
	public ArrayList<sbcommentDto> sbListComment(String sb_id) throws Exception {
		
		sbcommentDao dao = new sbcommentDao();
		
		ArrayList<sbcommentDto> list = dao.sbListComment(sb_id);
		
		return list;
	}
}
