package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardDAO.BoardDAO;
import boardDTO.BoardDTO;

@WebServlet("*.member")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		try {
			if(cmd.equals("/Login.member")) {

				BoardDAO dao = BoardDAO.getInstance();
				String id = request.getParameter("userId");
				String pw = dao.getSHA512(request.getParameter("userPw"));

				boolean result = dao.isMember(id,pw);
				if(result) {
					HttpSession session = request.getSession();
					session.setAttribute("loginID", id);
				}

				response.sendRedirect("/index.jsp");

			}else if(cmd.equals("/Insert.member")) {

				BoardDAO dao = BoardDAO.getInstance();
				String inputId = request.getParameter("inputID");
				String inputPw = dao.getSHA512(request.getParameter("inputPW"));
				String inputName = request.getParameter("inputNAME");
				String inputPhone = request.getParameter("inputPHONE");
				String inputEmail = request.getParameter("inputEMAIL");
				String inputPost = request.getParameter("inputPOST");
				String inputAddress1 = request.getParameter("inputADDRESS1");
				String inputAddress2 = request.getParameter("inputADDRESS2");

				int result = dao.insert(new BoardDTO(inputId,inputPw,inputName,inputPhone,
						inputEmail,inputPost,inputAddress1,inputAddress2,null));
				response.sendRedirect("/index.jsp?state=a_j");

			}else if(cmd.equals("/Logout.member")) {
				//			request.getSession().removeAttribute("");	// 원하는것만 삭제
				request.getSession().invalidate();   		// 모든것 삭제
				response.sendRedirect("/index.jsp");

			}else if(cmd.equals("/Mypage.member")) {

				BoardDAO dao = BoardDAO.getInstance();
				String userId = (String) request.getSession().getAttribute("loginID");

				BoardDTO dto = dao.selectId(userId);
				request.getSession().setAttribute("dto", dto);

				request.getRequestDispatcher("/member/Mypage.jsp").forward(request, response);

			}else if(cmd.equals("/idCheck.member")) {

				String id = request.getParameter("id");
				BoardDAO boardDao = BoardDAO.getInstance();
				boolean result = boardDao.isIdExist(id);

				request.setAttribute("result", result);
				request.getRequestDispatcher("/member/idCheckView.jsp").forward(request, response);

			}else if(cmd.equals("/MemberOut.member")) {

				BoardDAO dao = BoardDAO.getInstance();
				String id = (String) request.getSession().getAttribute("loginID");
				
				int result = dao.delete(id);	
				request.getSession().invalidate();
				response.sendRedirect("/index.jsp");
			}else if(cmd.equals("/Update.member")) {
				BoardDAO boardDao = BoardDAO.getInstance();
				String id = request.getParameter("");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
