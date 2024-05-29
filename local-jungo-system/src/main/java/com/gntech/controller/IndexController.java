package com.gntech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gntech.dto.orderDTO;
import com.gntech.service.IndexService;

// ��û��ȸ ��Ʈ�ѷ�
@Controller
public class IndexController {

	private IndexService indexService;

	// �ڵ����� �˻�
	@Autowired
	public IndexController(IndexService indexService) {
		super();
		this.indexService = indexService;
	}

	// ��û��ȸ ȭ��(����)
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView ListIndex(HttpServletRequest request) {
		System.out.println("ListIndex ȣ��");
		
		// ��û���� ������ ��ȣ
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));
		// �� �������� ǥ�õ� �� ����
		int pageSize = 12;
		// �� ����
		int count = 0;
		count = indexService.SelectIndexCount();		
		
		if (count == (currentPage - 1) * pageSize) {
			currentPage -= 1;
		}
		
		int startRow = (currentPage -1) * pageSize +1;	// ���� �������� ���۱� ��ȣ
		
		if (startRow < 0) {
			startRow = 1;
		}
		
		System.out.println("index �� ���� : " + count + "��");
		System.out.println("���� ������ ��ȣ : " + currentPage);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("list", indexService.ListIndex(startRow, pageSize));
		mav.addObject("count", count);
		
		return mav;
	}

	// ��û���� ����ȸ
	@RequestMapping(value = "/indexInfo", method = RequestMethod.GET)
	public ModelAndView SelectIndex(HttpServletRequest request) {
		System.out.println("SelectIndex ȣ��");
		
		// ����ȸ�ϱ� ���� �� ��ȣ  
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB�� �����Ͽ� ���� �޾ƿ�
		orderDTO dto = indexService.SelectIndex(id);
		System.out.println("�ֹ���ȣ : " + dto.getOrder_num());
		System.out.println("�̸� : " + dto.getOrder_name());
		
		return new ModelAndView("index_info", "select", dto);
	}

	// ��û���� ����
	@RequestMapping(value = "/checkY", method = RequestMethod.GET)
	public String CheckYIndex(HttpServletRequest request) {
		System.out.println("CheckY ȣ��");
		
		// ��û���� �����ϱ� ���� �� ��ȣ
		int id = Integer.parseInt(request.getParameter("id"));
		// ȸ�簡 ������ �ݾ�
		int return_price = Integer.parseInt(request.getParameter("return_price"));
		// �Ǹ��ڰ� ������ �ݾ�
		int price = Integer.parseInt(request.getParameter("price"));

		
		orderDTO dto = new orderDTO();
		dto.setId(id);
		dto.setReturn_price(return_price);

		int n = 0;

		// ���� �ݾ� ���� ������ (������)
		if (return_price == price) { 
			n = indexService.CheckYIndex(dto, 1);
		}
		// ���� �ݾ� ���� ������ (���԰�������)
		else { 
			n = indexService.CheckYIndex(dto, 2);
		}

		if (n > 0) {
			System.out.println("���º��� ����");
			return "redirect:/index?pageNum=1";
		} else {
			System.out.println("���º��� ����");
			return "redirect:/index?pageNum=1";
		}
	}

	// ��û���� ����
	@RequestMapping(value = "/checkN", method = RequestMethod.GET)
	public String CheckNIndex(HttpServletRequest request) {
		System.out.println("CheckN ȣ��");
		
		// ��û���� �����ϱ� ���� �� ��ȣ
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB�� �����Ͽ� �ŷ���� ����
		int n = indexService.CheckNIndex(id);
		if (n > 0) {
			System.out.println("�ŷ���� ����");
			return "redirect:/index?pageNum=1";
		} else {
			System.out.println("�ŷ���� ����");
			return "redirect:/index?pageNum=1";
		}
	}

}
