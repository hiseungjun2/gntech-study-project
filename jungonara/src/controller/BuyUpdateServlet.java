package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.buyBiz;
import dto.buyDto;

@WebServlet(name = "BuyUpdate", urlPatterns = { "/buyupdate" })
public class BuyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("buy_id"));	// 요청받은 글 번호
		
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		
		buyBiz biz = new buyBiz();
		
		buyDto dto = new buyDto();
		dto.setBuy_title(request.getParameter("buy_title"));
		dto.setBuy_contents(request.getParameter("buy_contents"));
		dto.setBuy_type(request.getParameter("buy_type"));
		dto.setBuy_subtype(request.getParameter("buy_subtype"));
		dto.setBuy_trade(request.getParameter("buy_trade"));
		dto.setBuy_price(request.getParameter("buy_price"));
		
		int n = 0;
		
		try {
			n = biz.buyUpdate(num, dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		
		if (n == 1) {
			out.println("alert('게시물 수정이 완료되었습니다.');");
		} else {
			out.println("alert('게시물 수정에 실패하였습니다.');");
		}
		out.println("location.href='/jungonara/mypagelist?buypageNum=1&sbpageNum=1&id="+userid+"';");
		out.println("</script>");
		out.close();
	}

}
