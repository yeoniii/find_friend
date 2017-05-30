package mini.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.service.BoardService;
import mini.service.ReplyService;
import mini.serviceImpl.BoardServiceImpl;
import mini.serviceImpl.ReplyServiceImpl;

//서블릿
public class BoardSelectController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			int page = 1; //기본페이지 = 1
			try {
				page = Integer.parseInt(request.getParameter("page"));
			}catch(Exception e){}
			
			HashMap<String, Object> map = null;
			List<Integer> replyCount = null;
			
			//요청 파라미터 조회 및 session으로 로그인 ID 받기
			String selectMethod = request.getParameter("selectMethod");
			String methodContent = request.getParameter("method");
			Member member = (Member)session.getAttribute("member");
			String memberId;
			session.removeAttribute("board");
			session.removeAttribute("reply");
			if(member == null) {
				memberId = null;
			} else {
				memberId = member.getMemberId();
			}
			
			// 
			BoardService boardService = BoardServiceImpl.getInstance();
			ReplyService replyService = ReplyServiceImpl.getInstance();
			
			// 각 게시물당 댓글 숫자 갖고 오기
			replyCount = replyService.selectReplyCount();
			
			// 비지니스 로직 처리
			if(selectMethod == null) {
				map = boardService.selectBoard(page);
				
			}else {
				map = boardService.selectBoardByMethod(page, selectMethod, methodContent);
			}

			// 결과 응답
			request.setAttribute("memberId", memberId);
			request.setAttribute("list", map.get("list"));
			request.setAttribute("replyCount", replyCount);
			request.setAttribute("pageBean", map.get("pageBean"));
			request.getRequestDispatcher("/boardList.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}