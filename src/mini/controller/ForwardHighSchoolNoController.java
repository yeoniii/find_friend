package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.HighSchool;
import mini.service.HighSchoolService;
import mini.service.MemberService;
import mini.serviceImpl.HighSchoolServiceImpl;
import mini.serviceImpl.MemberServiceImpl;

public class ForwardHighSchoolNoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberService memberService = MemberServiceImpl.getInstance();
		HighSchoolService schoolService = HighSchoolServiceImpl.getInstance();
		
		try {
			String schoolNoStr = req.getParameter("schoolNo");
			int schoolNo = Integer.parseInt(schoolNoStr);
			
			String schoolName = req.getParameter("schoolName");
			String memberId = req.getParameter("memberId");
			String memberEmail = req.getParameter("memberEmail"); 
		
			HighSchool school = schoolService.selectHighSchoolBySchoolNo(schoolNo);
			
			req.setAttribute("schoolNo", school.getSchoolNo());
			req.setAttribute("schoolName", school.getSchoolName());
			req.setAttribute("memberId", memberId);
			req.setAttribute("memberEmail", memberEmail);
			req.getRequestDispatcher("/signup/registerMember.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
