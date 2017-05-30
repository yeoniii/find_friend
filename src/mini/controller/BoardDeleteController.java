package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.service.BoardService;
import mini.serviceImpl.BoardServiceImpl;

public class BoardDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String memberId = request.getParameter("memberId");
		
		BoardService boardService = BoardServiceImpl.getInstance();
		
		boardService.deleteBoard(boardNo);
		
		if(memberId != null) {
			request.setAttribute("memberId", memberId);
			request.getRequestDispatcher("/selectMine").forward(request, response);
		} else {
			request.getRequestDispatcher("/select").forward(request, response);
		}	
	}
}
