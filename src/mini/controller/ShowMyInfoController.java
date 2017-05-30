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

public class ShowMyInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		MemberService memberService = MemberServiceImpl.getInstance();
		HighSchoolService schoolService = HighSchoolServiceImpl.getInstance();
		
		try{
			String memberId = req.getParameter("memberId");
			
			Member member = memberService.selectMemberById(memberId);
			HighSchool highSchool = schoolService.selectHighSchoolBySchoolNo(member.getSchoolNo());
			
			session.setAttribute("member", member);
			session.setAttribute("highSchool", highSchool);
			
			req.getRequestDispatcher("/showMyInfo.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
