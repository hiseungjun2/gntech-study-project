package biz;

import java.util.ArrayList;

import dao.sbDao;
import dto.sbDto;

public class sbBiz {

	public int getSbCount() throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.getSbCount();
		
		return n;
	}

	public ArrayList<sbDto> sbList(int startRow, int pageSize) throws Exception {
		
		sbDao dao = new sbDao();
		
		ArrayList<sbDto> list = dao.sbList(startRow, pageSize);
		
		return list;
		
	}

	public sbDto sbView(String num) throws Exception {
		
		sbDao dao = new sbDao();
		
		sbDto dto = dao.sbView(num);
		
		return dto;
	}

	public int sbUseridCount(String id) throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.sbUseridCount(id);
		
		return n;
	}

	public int sbSbtitleCount(String id) throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.sbSbtitleCount(id);
		
		return n;
	}

	public ArrayList<sbDto> sbUseridList(String id, int startRow, int pageSize) throws Exception {
		
		sbDao dao = new sbDao();
		
		ArrayList<sbDto> list = dao.sbUseridList(id, startRow, pageSize);
		
		return list;
	}

	public ArrayList<sbDto> sbSbtitleList(String id, int startRow, int pageSize) throws Exception {
		
		sbDao dao = new sbDao();
		
		ArrayList<sbDto> list = dao.sbSbtitleList(id, startRow, pageSize);
		
		return list;
	}

	public int sbWrite(sbDto dto) throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.sbWrite(dto);
		
		return n;
	}

	public int sbUpdate(int num, sbDto dto) throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.sbUpdate(num, dto);
		
		return n;
	}

	public int sbDelete(int sbid) throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.sbDelete(sbid);
		
		return n;
	}

	public int sbStatus(int sbid) throws Exception {
		
		sbDao dao = new sbDao();
		
		int n = dao.sbStatus(sbid);
		
		return n;
	}

}
