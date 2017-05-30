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

public class ReplyinsertController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
			
			int boardNo = 0;
			String replyContent = null;
			String loginMemberId = request.getParameter("loginMemberId");
			
			if(loginMemberId == "") {
				request.setAttribute("loginCheckInBoard", false); //로그인이 안 된 상태에서 게시글을 작성하려고 했을 때 false값 넣어서 보냄
				request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);
			} else {
				replyContent = request.getParameter("replyContent");
				boardNo = Integer.parseInt(request.getParameter("boardNo"));
				
				Timestamp date = new Timestamp(System.currentTimeMillis());

				Reply reply = new Reply(0, replyContent, date, boardNo, loginMemberId);
					
				ReplyService replysSrvice = ReplyServiceImpl.getInstance();
				replysSrvice.insertReply(reply);
					
				BoardService boardService = BoardServiceImpl.getInstance();
				Board board = boardService.selectBoardByBoardNo(boardNo);
				List <Reply> list = replysSrvice.selectReplyByBoardNo(boardNo);
					
				HttpSession session = request.getSession();
				
				session.setAttribute("loginMemberId", loginMemberId);
				session.setAttribute("board", board);
				session.setAttribute("reply", list);
				response.sendRedirect("/MiniProject/boardContentShow.jsp");
			}
			
		} catch(Exception e) {
			
		}
		
	}
}
