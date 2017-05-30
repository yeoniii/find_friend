package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Board;
import mini.service.BoardService;
import mini.serviceImpl.BoardServiceImpl;

public class BoardUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();

			int boardNo = Integer.parseInt(request.getParameter("boardNo"));

			//요청 파라미터 조회
			
			
			// 비지니스 로직 처리
			BoardService service = BoardServiceImpl.getInstance();
			Board board = service.selectBoardByBoardNo(boardNo);
				
			request.setAttribute("board", board);
				
			// 결과 응답
			request.getRequestDispatcher("/boardUpdate.jsp").forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
