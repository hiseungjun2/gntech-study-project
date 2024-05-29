package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.sbBiz;
import dto.sbDto;

@WebServlet(name = "SbInsert", urlPatterns = { "/sbinsert" })
public class SbInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		sbBiz biz = new sbBiz();
		
		sbDto dto = new sbDto();
		
		dto.setUser_id(request.getParameter("user_id"));
		dto.setSb_title(request.getParameter("sb_title"));
		dto.setSb_contents(request.getParameter("sb_contents"));
		dto.setSb_type(request.getParameter("sb_type"));
		dto.setSb_subtype(request.getParameter("sb_subtype"));
		dto.setSb_trade(request.getParameter("sb_trade"));
		dto.setSb_price(request.getParameter("sb_price"));
		
		int n = 0;
		
		try {
			n = biz.sbWrite(dto);
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
		out.println("location.href='/jungonara/sblist?pageNum=1';");
		out.println("</script>");
		out.close();
		
		
	}

}
