package mini.controller;

import java.io.IOException;
import java.sql.Timestamp;
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

public class ReplyUpdateController2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String replyContent = request.getParameter("replyContent");
		String memberId = request.getParameter("memberId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Timestamp date = new Timestamp(System.currentTimeMillis());
		
		Reply reply = new Reply(replyNo, replyContent, date, boardNo, memberId);
		
		BoardService boardService = BoardServiceImpl.getInstance();
		ReplyService replyService = ReplyServiceImpl.getInstance();
		
		Board board = boardService.selectBoardByBoardNo(boardNo);
		replyService.updateReply(reply);
		
		List<Reply> replyList = replyService.selectReplyByBoardNo(boardNo);
		
		session.setAttribute("reply", replyList);
		session.setAttribute("board", board);
		response.sendRedirect("/MiniProject/boardContentShow.jsp");
	}
}
