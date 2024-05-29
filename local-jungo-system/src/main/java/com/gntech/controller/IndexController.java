package com.gntech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gntech.dto.orderDTO;
import com.gntech.service.IndexService;

// 신청조회 컨트롤러
@Controller
public class IndexController {

	private IndexService indexService;

	// 자동으로 검색
	@Autowired
	public IndexController(IndexService indexService) {
		super();
		this.indexService = indexService;
	}

	// 신청조회 화면(메인)
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView ListIndex(HttpServletRequest request) {
		System.out.println("ListIndex 호출");
		
		// 요청받은 페이지 번호
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		// 한 페이지에 표시될 글 갯수
		int pageSize = 12;
		// 글 갯수
		int count = 0;
		count = indexService.SelectIndexCount();		
		
		if (count == (currentPage - 1) * pageSize) {
			currentPage -= 1;
		}
		
		int startRow = (currentPage -1) * pageSize +1;	// 현재 페이지의 시작글 번호
		
		if (startRow < 0) {
			startRow = 1;
		}
		
		System.out.println("index 글 갯수 : " + count + "개");
		System.out.println("현재 페이지 번호 : " + currentPage);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("list", indexService.ListIndex(startRow, pageSize));
		mav.addObject("count", count);
		
		return mav;
	}

	// 신청내역 상세조회
	@RequestMapping(value = "/indexInfo", method = RequestMethod.GET)
	public ModelAndView SelectIndex(HttpServletRequest request) {
		System.out.println("SelectIndex 호출");
		
		// 상세조회하기 위한 글 번호  
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB에 접근하여 정보 받아옴
		orderDTO dto = indexService.SelectIndex(id);
		System.out.println("주문번호 : " + dto.getOrder_num());
		System.out.println("이름 : " + dto.getOrder_name());
		
		return new ModelAndView("index_info", "select", dto);
	}

	// 신청내역 수락
	@RequestMapping(value = "/checkY", method = RequestMethod.GET)
	public String CheckYIndex(HttpServletRequest request) {
		System.out.println("CheckY 호출");
		
		// 신청내역 수락하기 위한 글 번호
		int id = Integer.parseInt(request.getParameter("id"));
		// 회사가 제시한 금액
		int return_price = Integer.parseInt(request.getParameter("return_price"));
		// 판매자가 제시한 금액
		int price = Integer.parseInt(request.getParameter("price"));

		
		orderDTO dto = new orderDTO();
		dto.setId(id);
		dto.setReturn_price(return_price);

		int n = 0;

		// 매입 금액 변동 없을때 (진행중)
		if (return_price == price) { 
			n = indexService.CheckYIndex(dto, 1);
		}
		// 매입 금액 변동 있을때 (매입가검토중)
		else { 
			n = indexService.CheckYIndex(dto, 2);
		}

		if (n > 0) {
			System.out.println("상태변경 성공");
			return "redirect:/index?pageNum=1";
		} else {
			System.out.println("상태변경 실패");
			return "redirect:/index?pageNum=1";
		}
	}

	// 신청내역 거절
	@RequestMapping(value = "/checkN", method = RequestMethod.GET)
	public String CheckNIndex(HttpServletRequest request) {
		System.out.println("CheckN 호출");
		
		// 신청내역 거절하기 위한 글 번호
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB에 접근하여 거래취소 변경
		int n = indexService.CheckNIndex(id);
		if (n > 0) {
			System.out.println("거래취소 성공");
			return "redirect:/index?pageNum=1";
		} else {
			System.out.println("거래취소 실패");
			return "redirect:/index?pageNum=1";
		}
	}

}
