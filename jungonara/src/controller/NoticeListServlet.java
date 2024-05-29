package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.noticeBiz;
import dto.noticeDto;

@WebServlet(name = "NoticeList", urlPatterns = { "/noticelist" })
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		noticeBiz biz = new noticeBiz();
		
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));		// ��û���� ������ ��ȣ�� Integer�� ��ȯ
		int pageSize = 12;
		int count = 0;
		
		try {
			count = biz.getNoticeCount();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		ArrayList<noticeDto> list = null;
		
		if (count == (currentPage-1)*pageSize) {
			currentPage -=1;
		}
		int startRow = (currentPage -1) * pageSize +1;	// ���� �������� ���۱� ��ȣ
		
		try {
			list = biz.noticeList(startRow, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("home/home_table.jsp");	// emplist.jsp �� list�� ����
		request.setAttribute("noticelist", list);
		request.setAttribute("noticecount", count);
		rd.forward(request, response);		// emplist�� ����
	}

}
