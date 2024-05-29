package com.gntech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gntech.dto.orderDTO;
import com.gntech.service.CheckService;

// 검토조회 컨트롤러
@Controller
public class CheckController {

	private CheckService checkService;

	@Autowired
	public CheckController(CheckService checkService) {
		super();
		this.checkService = checkService;
	}

	// 진행중인 상태 리스트
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ModelAndView ListCheck(HttpServletRequest request) {
		System.out.println("ListCheck 호출");
		
		// 요청받은 페이지 번호
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		// 한 페이지에 표시될 글 갯수
		int pageSize = 12;
		// 글 갯수
		int count = 0;
		count = checkService.SelectCheckCount();

		if (count == (currentPage - 1) * pageSize) {
			currentPage -= 1;
		}
		
		int startRow = (currentPage -1) * pageSize +1;	// 현재 페이지의 시작글 번호
		
		if (startRow < 0) {
			startRow = 1;
		}
		
		System.out.println("check 글 갯수 : " + count + "개");
		System.out.println("현재 페이지 번호 : " + currentPage);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("check");
		mav.addObject("list", checkService.ListCheck(startRow, pageSize));
		mav.addObject("count", count);
		
		return mav;
		
	}

	// 검토내역 상세조회
	@RequestMapping(value = "/checkInfo", method = RequestMethod.GET)
	public ModelAndView SelectCheck(HttpServletRequest request) {
		System.out.println("SelectCheck 호출");
		
		// 상세조회하기 위한 글 번호  
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB에 접근하여 정보 받아옴
		orderDTO dto = checkService.SelectCheck(id);
		System.out.println("주문번호 : " + dto.getOrder_num());
		System.out.println("이름 : " + dto.getOrder_name());
		System.out.println("주문날짜 : " + dto.getOrder_date());
		
		return new ModelAndView("check_info", "select", dto);
	}

	// 검토내역 메모 추가
	@RequestMapping(value = "/writeMemo", method = RequestMethod.GET)
	public String InsertMemo(HttpServletRequest request) {
		System.out.println("InsertMemo 호출");
		
		// 메모 작성하기위한 글 번호
		int id = Integer.parseInt(request.getParameter("id"));
		// 요청받은 글 메모
		String memo = request.getParameter("memo");
		
		orderDTO dto = new orderDTO();
		dto.setId(id);
		dto.setMemo(memo);
		
		int n = checkService.InsertMemo(dto);
		
		if (n > 0) {
			System.out.println("메모작성 성공");
			System.out.println("메모내용 : " + memo);
			return "redirect:/check?pageNum=1";
		} else {
			System.out.println("메모작성 실패");
			return "redirect:/check?pageNum=1";
		}
	}
	
	// 수거완료 
	@RequestMapping(value="/ResultStatus", method=RequestMethod.GET) 
	public String UpdateResult(HttpServletRequest request) {
		System.out.println("UpdateResult 호출");
		
		// 수거완료 하기위한 글 번호
		int id = Integer.parseInt(request.getParameter("id"));
		
		int n = checkService.UpdateResult(id);
		if (n > 0) {
			System.out.println("수거완료 성공");
			System.out.println("수거완료한 글 번호 : " + id);
			return "redirect:/result?pageNum=1&CancelpageNum=1";
		} else {
			System.out.println("수거완료 실패");
			return "redirect:/result?pageNum=1&CancelpageNum=1";
		}
	}

}
