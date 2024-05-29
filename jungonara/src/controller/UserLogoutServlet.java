package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// �α׾ƿ�
@WebServlet(name = "UserLogout", urlPatterns = { "/userlogout" })
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email"); 
		
		
		if (email != null) {
//			session.removeAttribute("logOk");
			session.invalidate();
			response.sendRedirect("./log/logOut.jsp"); // �α׾ƿ� �Ŀ� ȭ���̵�
		} else {
			response.sendRedirect("./index.html");
		}
	}

}
