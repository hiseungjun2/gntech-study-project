package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.buycommentBiz;
import dto.buycommentDto;


@WebServlet(name = "BuyCommentInsert", urlPatterns = { "/buycommentinsert" })
public class BuyCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		buycommentBiz biz = new buycommentBiz();
		
		String buy_id = request.getParameter("buy_id");
		String user_id = request.getParameter("user_id");
		String info = request.getParameter("info");
		
		buycommentDto dto = new buycommentDto();
		dto.setBuy_id(buy_id);
		dto.setComment_content(request.getParameter("comment_content"));
		dto.setUser_id(user_id);
		
		try {
			biz.buyInsertComment(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		if (info.equals("")) {
			out.println("location.href='/jungonara/buylistinfo?num=" + buy_id + "';");
		} else {
			out.println("location.href='/jungonara/buyselectlistinfo?num=" + buy_id + "';");
		}
		out.println("</script>");
		out.close();
	}

}
