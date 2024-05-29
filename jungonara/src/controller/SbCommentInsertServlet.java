package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.sbcommentBiz;
import dto.sbcommentDto;


@WebServlet(name = "SbCommentInsert", urlPatterns = { "/sbcommentinsert" })
public class SbCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		sbcommentBiz biz = new sbcommentBiz();
		
		String sb_id = request.getParameter("sb_id");
		String user_id = request.getParameter("user_id");
		String info = request.getParameter("info");
		
		sbcommentDto dto = new sbcommentDto();
		dto.setSb_id(sb_id);
		dto.setComment_content(request.getParameter("comment_content"));
		dto.setUser_id(user_id);
		
		try {
			biz.sbInsertComment(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		if (info.equals("")) {
			out.println("location.href='/jungonara/sblistinfo?num=" + sb_id + "';");
		} else {
			out.println("location.href='/jungonara/sbselectlistinfo?num=" + sb_id + "';");
		}
		out.println("</script>");
		out.close();
	}

}
