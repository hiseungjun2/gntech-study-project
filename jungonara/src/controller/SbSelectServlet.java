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

@WebServlet(name = "SbSelect", urlPatterns = { "/sbselect" })
public class SbSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("optionSelect");
		String id = request.getParameter("inputSelect");
		
		sbBiz biz = new sbBiz();
		
		int currentPage = Integer.parseInt(request.getParameter("pageNum"));		// 요청받은 페이지 번호를 Integer로 변환
		int pageSize = 12;
		int count = 0;
		
		if(select.equals("user_id")) {
			try {
				count = biz.sbUseridCount(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(select.equals("sb_title")) {
			try {
				count = biz.sbSbtitleCount(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ArrayList<sbDto> list = null;
		
		if (count == (currentPage-1)*pageSize) {
			currentPage -=1;
		}
		int startRow = (currentPage -1) * pageSize +1;	// 현재 페이지의 시작글 번호
		
		if(select.equals("user_id")) {
			try {
				list = biz.sbUseridList(id, startRow, pageSize);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(select.equals("sb_title")) {
			try {
				list = biz.sbSbtitleList(id, startRow, pageSize);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("sb/sb_table_select.jsp");	
		request.setAttribute("sbselectlist", list);
		request.setAttribute("sbselectcount", count);
		request.setAttribute("sbopenselect", select);
		request.setAttribute("sbinputselect", id);
		rd.forward(request, response);
	}

}
