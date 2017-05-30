package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.HighSchool;
import mini.VO.Member;
import mini.service.HighSchoolService;
import mini.service.MemberService;
import mini.serviceImpl.HighSchoolServiceImpl;
import mini.serviceImpl.MemberServiceImpl;

public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		HighSchoolService schoolService = HighSchoolServiceImpl.getInstance();
		
		try{
			String memberId = req.getParameter("id");
			String memberPassword = req.getParameter("password");
		
			Member member = service.loginCheck(memberId, memberPassword);
			HighSchool highSchool = schoolService.selectHighSchoolBySchoolNo(member.getSchoolNo());
			
			if(member != null) {
				session.setAttribute("member", member);
				req.getRequestDispatcher("/login/login_success.jsp").forward(req, resp);
			}else {
				throw new Exception();
			}
		}catch(Exception e){
			req.setAttribute("login", false); //로그인 실패시 false값 넣어서 보냄
			req.getRequestDispatcher("/login/login_form.jsp").forward(req, resp);
		}
	}
}
