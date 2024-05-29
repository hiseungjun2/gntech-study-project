package com.gntech.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gntech.dto.orderDTO;

@Repository("indexDAO")
public class IndexDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	// 신청현황 리스트
	public List<orderDTO> ListIndex(int startRow, int pageSize) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", startRow-1);
		map.put("end", pageSize);
		List<orderDTO> list = sqlSessionFactory.openSession().selectList("usernamespace.ListIndex", map);
		return list;
	}
	
	// 신청현황 글 갯수
	public int SelectIndexCount() {
		int n = sqlSessionFactory.openSession().selectOne("usernamespace.SelectIndexCount");
		return n;
	}

	// 신청내역 상세조회
	public orderDTO SelectIndex(int id) {
		orderDTO dto = sqlSessionFactory.openSession().selectOne("usernamespace.SelectIndex", id);
		return dto;
	}

	// 신청내역 수락
	public int CheckYIndex(orderDTO dto, int i) {
		int n = 0;
		if (i == 1) {		// 금액 변동이 없으면 (진행중)
			n = sqlSessionFactory.openSession().update("usernamespace.CheckYIndex", dto);
		} else {		// 금액 변동이 있으면 (매입가검토중)
			n = sqlSessionFactory.openSession().update("usernamespace.CheckYIndexPrice", dto);
		} 
		return n;
	}

	// 신청내역 거절
	public int CheckNIndex(int id) {
		int n = sqlSessionFactory.openSession().update("usernamespace.CheckNIndex", id);
		return n;
	}

}
