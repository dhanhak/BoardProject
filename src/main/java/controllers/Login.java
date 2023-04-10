package controllers;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardDAO.BoardDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("userId");
		String pw = dao.getSHA512(request.getParameter("userPw"));

		try {
			boolean result = dao.isMember(id,pw);

			// 로그인에 성공할 시 cookie파일 생성 
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("loginID", id);
			}
			
			response.sendRedirect("/index.jsp");

//			System.out.println("로그인 성공 여부 : " + result);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
