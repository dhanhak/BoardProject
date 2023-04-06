package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;

@WebServlet("/idCheck")
public class idCheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BoardDAO boardDao = BoardDAO.getInstance();
		try {
			boolean result = boardDao.isIdExist(id);
			if(result==false) {
				System.out.println("등록된 아이디가 없습니다.");
			}else {
				System.out.println("중복된 아이디입니다.");
			}
			
			request.getRequestDispatcher("/joinform").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
