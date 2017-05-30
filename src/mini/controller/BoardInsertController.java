package mini.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Board;
import mini.VO.Member;
import mini.service.BoardService;
import mini.serviceImpl.BoardServiceImpl;

//서블릿
public class BoardInsertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// session 생성
			HttpSession session = request.getSession();
			
			//요청 파라미터 조회 받기
			Member member = (Member)session.getAttribute("member");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Timestamp date = new Timestamp(System.currentTimeMillis());
			int hits = 0;
			String MemberId = member.getMemberId();	//session에서 받아야 함
			
			Board board = new Board(0, title, content, date, hits, MemberId);
			
			// 비지니스 로직 처리
			BoardService service = BoardServiceImpl.getInstance();
			int boardNo = service.insertBoard(board);
			board = service.selectBoardByBoardNo(boardNo);
			
			// 결과 응답
			session.setAttribute("memberId", MemberId );
			session.setAttribute("board", board);
			response.sendRedirect("/MiniProject/boardContentShow.jsp");
		}catch(Exception e) {
			request.setAttribute("loginCheckInBoard", false); //로그인이 안 된 상태에서 게시글을 작성하려고 했을 때 false값 넣어서 보냄
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);
		}
	}
}