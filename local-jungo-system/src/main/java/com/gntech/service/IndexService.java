package com.gntech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gntech.dao.IndexDAO;
import com.gntech.dto.orderDTO;

@Service("indexService")
public class IndexService {

	private IndexDAO indexDAO;

	@Autowired
	public IndexService(IndexDAO indexDAO) {
		super();
		this.indexDAO = indexDAO;
	}

	// ��û��Ȳ
	public List<orderDTO> ListIndex(int startRow, int pageSize) {
		return indexDAO.ListIndex(startRow, pageSize);
	}
	
	// ��û��Ȳ �� �� ��
	public int SelectIndexCount() {
		return indexDAO.SelectIndexCount();
	}

	// ����ȸ
	public orderDTO SelectIndex(int id) {
		return indexDAO.SelectIndex(id);
	}

	// ��û���� ����
	public int CheckYIndex(orderDTO dto, int i) {
		return indexDAO.CheckYIndex(dto, i);
	}

	// ��û���� ����
	public int CheckNIndex(int id) {
		return indexDAO.CheckNIndex(id);
	}

}
