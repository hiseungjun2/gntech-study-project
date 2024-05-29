package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.noticeBiz;
import dto.noticeDto;

@WebServlet(name = "NoticeListInfo", urlPatterns = { "/noticelistinfo" })
public class NoticeListInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		noticeBiz biz = new noticeBiz();
		
		String num = request.getParameter("num");
		int count = 0;
	
		noticeDto dto = new noticeDto();
		
		try {
			count = biz.getNoticeCount();
			dto = biz.noticeView(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("home/home_table_info.jsp");	// emplist.jsp 로 list를 보냄
		request.setAttribute("noticelistinfo", dto);
		request.setAttribute("noticecount", count);
		rd.forward(request, response);		// emplist로 위임
	}

}
