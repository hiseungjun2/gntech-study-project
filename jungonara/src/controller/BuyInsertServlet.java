package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.buyBiz;
import dto.buyDto;

@WebServlet(name = "BuyInsert", urlPatterns = { "/buyinsert" })
public class BuyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		buyBiz biz = new buyBiz();
		
		buyDto dto = new buyDto();
		
		dto.setUser_id(request.getParameter("user_id"));
		dto.setBuy_title(request.getParameter("buy_title"));
		dto.setBuy_contents(request.getParameter("buy_contents"));
		dto.setBuy_type(request.getParameter("buy_type"));
		dto.setBuy_subtype(request.getParameter("buy_subtype"));
		dto.setBuy_trade(request.getParameter("buy_trade"));
		dto.setBuy_price(request.getParameter("buy_price"));
		
		int n = 0;
		
		try {
			n = biz.buyWrite(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		
		if (n == 1) {
			out.println("alert('게시물이 등록되었습니다.');");
		} else {
			out.println("alert('게시물 등록에 실패하였습니다.');");
		}
		out.println("location.href='/jungonara/buylist?pageNum=1';");
		out.println("</script>");
		out.close();
		
		
	}

}
