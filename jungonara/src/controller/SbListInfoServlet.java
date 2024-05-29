package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.sbBiz;
import dto.sbDto;

@WebServlet(name = "SbListInfo", urlPatterns = { "/sblistinfo" })
public class SbListInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		sbBiz biz = new sbBiz();
		
		String num = request.getParameter("num");
		int count = 0;
		
		sbDto dto = new sbDto();
		
		try {
			count = biz.getSbCount();
			dto = biz.sbView(num);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("sb/sb_table_info.jsp");	// emplist.jsp 로 list를 보냄
		request.setAttribute("sblistinfo", dto);
		request.setAttribute("sbcount", count);
		rd.forward(request, response);		// emplist로 위임
	}

}
