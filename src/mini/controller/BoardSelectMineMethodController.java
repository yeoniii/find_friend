package mini.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.service.BoardService;
import mini.service.ReplyService;
import mini.serviceImpl.BoardServiceImpl;
import mini.serviceImpl.ReplyServiceImpl;

public class BoardSelectMineMethodController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int page = 1; //기본페이지 = 1
			try {
				page = Integer.parseInt(request.getParameter("page"));
			}catch(Exception e){}
			
			HashMap<String, Object> map = null;
			List<Integer> replyCount = null;
			//요청 파라미터 조회
			String selectMethod = request.getParameter("selectMethod");
			String methodContent = request.getParameter("method");
			
			// 비지니스 로직 처리
			BoardService boardService = BoardServiceImpl.getInstance();
			ReplyService replyService = ReplyServiceImpl.getInstance();

			replyCount = replyService.selectReplyCount();
	
			if(selectMethod == null) {
				map = boardService.selectBoard(page);
				
			}else {
				map = boardService.selectBoardByMethod(page, selectMethod, methodContent);
			}

			// 결과 응답
			request.setAttribute("list", map.get("list"));
			request.setAttribute("replyCount", replyCount);
			request.setAttribute("pageBean", map.get("pageBean"));
			request.getRequestDispatcher("/boardMyList.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}