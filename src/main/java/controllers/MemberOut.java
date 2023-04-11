package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;

@WebServlet("/MemberOut")
public class MemberOut extends HttpServlet {
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BoardDAO dao = BoardDAO.getInstance();
    	response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = (String) request.getSession().getAttribute("loginID");
		try {
			int result = dao.delete(id);
			
			if(result == 1) {
				System.out.println("회원탈퇴 완료!");
				request.getSession().invalidate();
			}
			response.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
