package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.buyBiz;
import dto.buyDto;

@WebServlet(name = "BuySelectInfo", urlPatterns = { "/buyselectinfo" })
public class BuySelectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		buyBiz biz = new buyBiz();
		
		String num = request.getParameter("num");
		int count = 0;
		
		buyDto dto = new buyDto();
		
		try {
			count = biz.getBuyCount();
			dto = biz.buyView(num);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("buy/buy_table_select_info.jsp");	// emplist.jsp 로 list를 보냄
		request.setAttribute("buyselectlistinfo", dto);
		request.setAttribute("buyselectcount", count);
		rd.forward(request, response);		// emplist로 위임
		
	}

}
