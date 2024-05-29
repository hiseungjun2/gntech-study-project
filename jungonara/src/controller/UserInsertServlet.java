package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.userBiz;
import dto.userDto;

// 회원가입
@WebServlet(name = "UserInsert", urlPatterns = { "/userinsert" })
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		userDto dto = new userDto();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setUser_email(request.getParameter("user_email"));
		dto.setUser_pw(request.getParameter("user_pw"));
		
		userBiz biz = new userBiz();
		
		int n = 0;
		try {
			n = biz.insertUser(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 회원가입 성공
		if (n > 0) {
			response.sendRedirect("./log/joinOk.jsp");
		} else {
			response.sendRedirect("./log/joinFail.jsp");
		}
	}

}
