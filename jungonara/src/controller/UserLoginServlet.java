package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.userBiz;

// ·Î±×ÀÎ
@WebServlet(name = "UserLogin", urlPatterns = { "/userlogin" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("user_email");
		String pw = request.getParameter("user_pw");
		String id = null;
		
		userBiz biz = new userBiz();
		
		int n = 0;
		
		try {
			n = biz.checkUser(email, pw);
			id = biz.openUserid(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (n == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("./log/loginOk.jsp");
		} else  if (n == 0) {	
			response.sendRedirect("./log/loginNoPw.jsp");
		} else {
			response.sendRedirect("./log/loginNoId.jsp");
		}
		
	}

}
