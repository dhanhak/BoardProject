package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.BoardDAO;
import boardDTO.BoardDTO;
import comm.DatatypeConverter;

@WebServlet("/BoardInsert")
public class BoardInsert extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String inputId = request.getParameter("inputID");
		String inputPw = DatatypeConverter.getSHA256(request.getParameter("inputPW"));
		String inputName = request.getParameter("inputNAME");
		String inputPhone = request.getParameter("inputPHONE");
		String inputEmail = request.getParameter("inputEMAIL");
		String inputPost = request.getParameter("inputPOST");
		String inputAddress1 = request.getParameter("inputADDRESS1");
		String inputAddress2 = request.getParameter("inputADDRESS2");
		
		try {
			int result = dao.insert(new BoardDTO(inputId,inputPw,inputName,inputPhone,
					inputEmail,inputPost,inputAddress1,inputAddress2,null));
			response.sendRedirect("/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
