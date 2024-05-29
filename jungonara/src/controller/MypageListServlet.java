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
import biz.sbBiz;
import dto.buyDto;
import dto.sbDto;

@WebServlet(name = "MypageList", urlPatterns = { "/mypagelist" })
public class MypageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		buyBiz bbiz = new buyBiz();
		sbBiz sbiz = new sbBiz();
		
		int pageSize = 5;
		int buyCount = 0;
		int sbCount = 0;
		
		String id = request.getParameter("id");
		int sbCurrentPage = Integer.parseInt(request.getParameter("buypageNum"));
		int buyCurrentPage = Integer.parseInt(request.getParameter("sbpageNum"));
		
		ArrayList<buyDto> buy = null;	// buyDto 선언
		ArrayList<sbDto> sb = null;	// sbDto 선언	
		
		try {
			buyCount = bbiz.buyUseridCount(id);
			sbCount = sbiz.sbUseridCount(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (buyCount == (buyCurrentPage-1)*pageSize) {		// 삽니다 글 갯수가 0 일때
			buyCurrentPage -=1;	
		}
		
		if (sbCount == (sbCurrentPage-1)*pageSize) {	// 팝니다 글 갯수가 0 일때
			sbCurrentPage -=1;	
		}
		
		int buyStartRow = (buyCurrentPage-1) * pageSize +1;	// 삽니다 글 조회 위한 시작 번호 설정
		int sbStartRow = (sbCurrentPage-1) * pageSize +1;	// 팝니다 글 조회 위한 시작 번호 설정
		
		//------------------------------------------------------------
		
		try {
			buy = bbiz.buyUseridList(id, buyStartRow, pageSize);		// 팝니다 글 세팅
			sb = sbiz.sbUseridList(id, sbStartRow, pageSize);		// 삽니다 글 세팅
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("mypage/mypage_table.jsp");	
		request.setAttribute("buylist", buy);
		request.setAttribute("sblist", sb);
		request.setAttribute("buycount", buyCount);
		request.setAttribute("sbcount", sbCount);
		rd.forward(request, response);		
		
	
	}

}
