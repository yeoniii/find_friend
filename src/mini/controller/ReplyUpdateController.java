package mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.Board;
import mini.VO.Reply;
import mini.service.BoardService;
import mini.service.ReplyService;
import mini.serviceImpl.BoardServiceImpl;
import mini.serviceImpl.ReplyServiceImpl;

public class ReplyUpdateController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");
		
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		ReplyService replyService = ReplyServiceImpl.getInstance();
		BoardService boardService = BoardServiceImpl.getInstance();
		
		List<Reply> replyList = replyService.selectReplyByBoardNo(boardNo);
		Board board = boardService.selectBoardByBoardNo(boardNo);
		
		request.setAttribute("replyList", replyList);
		request.setAttribute("board", board);
		request.setAttribute("replyNo", replyNo);
		request.getRequestDispatcher("/replyUpdate.jsp").forward(request, response);
	}
}
