package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.buyBiz;
import dto.buyDto;

@WebServlet(name = "BuySelect", urlPatterns = { "/buyselect" })
public class BuySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("optionSelect");
		String id = request.getParameter("inputSelect");
		
		buyBiz biz = new buyBiz();
		
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));		// 요청받은 페이지 번호를 Integer로 변환
		int pageSize = 12;
		int count = 0;
		
		if(select.equals("user_id")) {
			try {
				count = biz.buyUseridCount(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(select.equals("buy_title")) {
			try {
				count = biz.buyBuytitleCount(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ArrayList<buyDto> list = null;
		
		if (count == (currentPage-1)*pageSize) {
			currentPage -=1;
		}
		int startRow = (currentPage -1) * pageSize +1;	// 현재 페이지의 시작글 번호
		
		if(select.equals("user_id")) {
			try {
				list = biz.buyUseridList(id, startRow, pageSize);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(select.equals("buy_title")) {
			try {
				list = biz.buyBuytitleList(id, startRow, pageSize);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("buy/buy_table_select.jsp");	
		request.setAttribute("buyselectlist", list);
		request.setAttribute("buyselectcount", count);
		request.setAttribute("buyopenselect", select);
		request.setAttribute("buyinputselect", id);
		rd.forward(request, response);
	}

}
