package mini.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.service.BoardService;
import mini.serviceImpl.BoardServiceImpl;

public class BoardSelectMineController extends HttpServlet {
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
			
			//요청 파라미터 조회 및 session으로 부터 로그인 ID 받기
			Member member = (Member)session.getAttribute("member");
			String writer = member.getMemberId();
			
			// 비지니스 로직 처리
			BoardService service = BoardServiceImpl.getInstance();
			HashMap<String, Object> map = service.selectBoardMine(page, writer);

			// 결과 응답
			request.setAttribute("list", map.get("list"));
			request.setAttribute("pageBean", map.get("pageBean"));
			request.getRequestDispatcher("/boardMyList.jsp").forward(request, response);
		}catch(Exception e) {
			request.setAttribute("loginCheckInBoard", false);
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);
		}
	}
}
