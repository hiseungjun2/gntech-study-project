package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.sbBiz;
import dto.sbDto;

@WebServlet(name = "SbList", urlPatterns = { "/sblist" })
public class SbListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		sbBiz biz = new sbBiz();
		
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));		// 요청받은 페이지 번호를 Integer로 변환
		int pageSize = 12;
		int count = 0;
		
		try {
			count = biz.getSbCount();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		ArrayList<sbDto> list = null;
		
		if (count == (currentPage-1)*pageSize) {
			currentPage -=1;
		}
		int startRow = (currentPage -1) * pageSize +1;	// 현재 페이지의 시작글 번호
		
		try {
			list = biz.sbList(startRow, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("sb/sb_table.jsp");	
		request.setAttribute("sblist", list);
		request.setAttribute("sbcount", count);
		rd.forward(request, response);		
		
		
	}
}
