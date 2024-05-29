package com.gntech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gntech.dto.orderDTO;
import com.gntech.service.ResultService;

// 완료조회 컨트롤러
@Controller
public class ResultController {
	
	private ResultService resultService;
	
	@Autowired
	public ResultController(ResultService resultService) {
		super();
		this.resultService = resultService;
	}

	// 결과조회 리스트
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView ListResult(HttpServletRequest request) {
		System.out.println("ListResult 호출");
		
		// 한 페이지 글 갯수
		int pageSize = 5;
		// 완료 글 갯수
		int count = resultService.SelectResultCount();
		// 취소 글 갯수
		int cancelcount = resultService.SelectResultCancelCount();
		
		// 각 요청받은 페이지 번호
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		int cancelcurrentPage = Integer.parseInt(request.getParameter("CancelpageNum"));
		
		if (count == (currentPage-1)*pageSize) {		// 완료 글 갯수가 0 일때
			currentPage -=1;	
		}
		
		if (cancelcount == (cancelcurrentPage-1)*pageSize) {	// 취소 글 갯수가 0 일때
			cancelcurrentPage -=1;	
		}
		
		int startRow = (currentPage-1) * pageSize + 1;
		int cancelstartRow = (cancelcurrentPage -1) * pageSize + 1;
		
		if (startRow < 0) {
			startRow = 1;
		}
		if (cancelstartRow < 0) {
			cancelstartRow = 1;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		mav.addObject("list", resultService.ListResult(startRow, pageSize));
		mav.addObject("cancellist", resultService.ListResultCancel(cancelstartRow, pageSize));
		mav.addObject("count", count);
		mav.addObject("cancelcount", cancelcount);
		
		return mav;
	}
	
	// 결과조회 상세보기
	@RequestMapping(value="/resultInfo", method = RequestMethod.GET)
	public ModelAndView SelectResult(HttpServletRequest request) {
		System.out.println("SelectResult 호출");
		
		// 상세보기위한 글 번호
		int id = Integer.parseInt(request.getParameter("id"));
		
		orderDTO dto = resultService.SelectResult(id);
		System.out.println("주문번호 : " + dto.getOrder_num());
		System.out.println("이름 : " + dto.getOrder_name());
		
		return new ModelAndView("result_info", "select", dto);
	}
	
}
