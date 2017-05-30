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

public class BoardSelectInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//요청 파라미터 조회
			HttpSession session = request.getSession();
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			String boardTitle = request.getParameter("title");
			String boardContent = request.getParameter("content");
			Timestamp date = Timestamp.valueOf(request.getParameter("date"));
			int boardHits = Integer.parseInt(request.getParameter("boardHits"));
			String memberId = request.getParameter("memberId");
			String loginMemberId = request.getParameter("loginMemberId");
			boardHits++;
			
			BoardService boardService = BoardServiceImpl.getInstance();
			ReplyService replyService = ReplyServiceImpl.getInstance();
			
			boardService.updateBoard(new Board(boardNo, boardTitle, boardContent, date, boardHits, memberId));
			session.removeAttribute("reply");
			session.removeAttribute("board");
			Board board = boardService.selectBoardByBoardNo(boardNo);
			List<Reply> list = replyService.selectReplyByBoardNo(boardNo);
			// 비지니스 로직 처리
			
			// 결과 응답
			request.setAttribute("loginMemberId", loginMemberId);
			request.setAttribute("board", board);
			request.setAttribute("reply", list);
			request.getRequestDispatcher("/boardContentShow.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}