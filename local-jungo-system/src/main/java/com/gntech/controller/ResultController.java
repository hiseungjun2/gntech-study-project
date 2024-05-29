package com.gntech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gntech.dto.orderDTO;
import com.gntech.service.ResultService;

// �Ϸ���ȸ ��Ʈ�ѷ�
@Controller
public class ResultController {
	
	private ResultService resultService;
	
	@Autowired
	public ResultController(ResultService resultService) {
		super();
		this.resultService = resultService;
	}

	// �����ȸ ����Ʈ
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView ListResult(HttpServletRequest request) {
		System.out.println("ListResult ȣ��");
		
		// �� ������ �� ����
		int pageSize = 5;
		// �Ϸ� �� ����
		int count = resultService.SelectResultCount();
		// ��� �� ����
		int cancelcount = resultService.SelectResultCancelCount();
		
		// �� ��û���� ������ ��ȣ
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		int cancelcurrentPage = Integer.parseInt(request.getParameter("CancelpageNum"));
		
		if (count == (currentPage-1)*pageSize) {		// �Ϸ� �� ������ 0 �϶�
			currentPage -=1;	
		}
		
		if (cancelcount == (cancelcurrentPage-1)*pageSize) {	// ��� �� ������ 0 �϶�
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
	
	// �����ȸ �󼼺���
	@RequestMapping(value="/resultInfo", method = RequestMethod.GET)
	public ModelAndView SelectResult(HttpServletRequest request) {
		System.out.println("SelectResult ȣ��");
		
		// �󼼺������� �� ��ȣ
		int id = Integer.parseInt(request.getParameter("id"));
		
		orderDTO dto = resultService.SelectResult(id);
		System.out.println("�ֹ���ȣ : " + dto.getOrder_num());
		System.out.println("�̸� : " + dto.getOrder_name());
		
		return new ModelAndView("result_info", "select", dto);
	}
	
}
