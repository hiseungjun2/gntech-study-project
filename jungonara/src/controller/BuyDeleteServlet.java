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

@WebServlet(name = "BuyDelete", urlPatterns = { "/buydelete" })
public class BuyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		buyBiz biz = new buyBiz();
		
		int buyid = Integer.parseInt(request.getParameter("buyid"));
		
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		
		int n = 0;
		
		try {
			n = biz.buyDelete(buyid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		
		if (n == 1) {
			out.println("alert('"+buyid+"번 게시글 삭제가 완료되었습니다.');");
		} else {
			out.println("alert('게시글 삭제에 실패하였습니다.');");
		}
		out.println("location.href='/jungonara/mypagelist?buypageNum=1&sbpageNum=1&id="+userid+"';");
		out.println("</script>");
		out.close();
	}

}
