package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.sbBiz;
import dto.sbDto;

@WebServlet(name = "SbUpdate", urlPatterns = { "/sbupdate" })
public class SbUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("sb_id"));	// 요청받은 글 번호
		
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		
		sbBiz biz = new sbBiz();
		
		sbDto dto = new sbDto();
		dto.setSb_title(request.getParameter("sb_title"));
		dto.setSb_contents(request.getParameter("sb_contents"));
		dto.setSb_type(request.getParameter("sb_type"));
		dto.setSb_subtype(request.getParameter("sb_subtype"));
		dto.setSb_trade(request.getParameter("sb_trade"));
		dto.setSb_price(request.getParameter("sb_price"));
		
		int n = 0;
		
		try {
			n = biz.sbUpdate(num, dto);
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
