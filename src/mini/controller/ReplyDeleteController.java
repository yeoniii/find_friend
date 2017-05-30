package mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Board;
import mini.VO.Reply;
import mini.service.BoardService;
import mini.service.ReplyService;
import mini.serviceImpl.BoardServiceImpl;
import mini.serviceImpl.ReplyServiceImpl;

public class ReplyDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		ReplyService replyService = ReplyServiceImpl.getInstance();
		BoardService boardService = BoardServiceImpl.getInstance();
		
		replyService.deleteReply(replyNo);
		
		List<Reply> replyList = replyService.selectReplyByBoardNo(boardNo);
		Board board = boardService.selectBoardByBoardNo(boardNo);
		
		session.setAttribute("board", board);
		session.setAttribute("reply", replyList);
		response.sendRedirect("/MiniProject/boardContentShow.jsp");
	}
}
