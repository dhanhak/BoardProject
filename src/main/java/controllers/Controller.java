package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardDAO.DAO;
import boardDTO.DTO;

@WebServlet("*.board")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		try {
			if(cmd.equals("/list.board")) {
				DAO dao = DAO.getInstance();
				List<DTO> list = dao.boardView();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
				
			}else if(cmd.equals("/write.board")) {
				
				request.getRequestDispatcher("/board/write.jsp").forward(request, response);
				
			}else if(cmd.equals("/insertwrite.board")) {
				
				DAO dao = DAO.getInstance();
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String contents = request.getParameter("contents");
				dao.insert(new DTO(0,writer,title,contents,0,null));
				
				response.sendRedirect("/index.jsp");
				
			}else if(cmd.equals("/title.board")) {
				
				DAO dao = DAO.getInstance();
				int seq = Integer.parseInt(request.getParameter("seq"));
				DTO titleDto = dao.titleView(seq);
				request.getSession().setAttribute("titleDto", titleDto);
				request.getRequestDispatcher("/board/selectTitle.jsp").forward(request, response);
				
			}else if(cmd.equals("/update.board")) {
				
				DAO dao = DAO.getInstance();
				DTO dto = (DTO) request.getAttribute("titleDto");
				request.setAttribute("titleDto", dto);
				request.getRequestDispatcher("/board/boardMod.jsp").forward(request, response);
				
			}else if(cmd.equals("/updateboard.board")) {
				
				DAO dao = DAO.getInstance();
				
				int seq = Integer.parseInt(request.getParameter("seq"));
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				
				dao.update(seq,title,contents);
				
				response.sendRedirect("/index.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
