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

public class UpdateMemberInfoController extends HttpServlet{

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
			String memberPassword = req.getParameter("memberPassword");
			String memberName = req.getParameter("memberName");

			int graduateYear = Integer.parseInt(req.getParameter("graduateYear"));
			String memberEmail = req.getParameter("memberEmail");
			char memberGender = req.getParameter("memberGender").charAt(0);
			
			String schoolNoStr = req.getParameter("schoolNo");
			int schoolNo = Integer.parseInt(schoolNoStr);
			
			HighSchool highSchool = schoolService.selectHighSchoolBySchoolNo(schoolNo);
			
			Member member = new Member(memberId, memberPassword, memberName, graduateYear, memberEmail, memberGender, schoolNo, highSchool);
			
			memberService.updateMember(member);

			session.setAttribute("member", member);
			session.setAttribute("highSchool", highSchool);
			req.getRequestDispatcher("/updateSuccess.jsp").forward(req, resp);
			
			}catch (Exception e){
				e.printStackTrace();
		}	
	}
}
