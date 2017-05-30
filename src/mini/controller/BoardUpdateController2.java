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

public class BoardUpdateController2 extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session = request.getSession();
			
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			String boardTitle = request.getParameter("boardTitle");
			String boardContent = request.getParameter("boardContent");
			Timestamp date = Timestamp.valueOf(request.getParameter("boardDate"));
			int boardHits = Integer.parseInt(request.getParameter("boardHits"));
			String memberId = request.getParameter("memberId");
			
			Board board = new Board(boardNo, boardTitle, boardContent, date, boardHits, memberId);
			
			ReplyService replyService = ReplyServiceImpl.getInstance();
			BoardService boardService = BoardServiceImpl.getInstance();
			
			List <Reply> replyList = replyService.selectReplyByBoardNo(boardNo);
			boardService.updateBoard(board);
			
			session.setAttribute("reply", replyList);
			session.setAttribute("board", board);
			request.getRequestDispatcher("/boardContentShow.jsp").forward(request, response);
		}
}