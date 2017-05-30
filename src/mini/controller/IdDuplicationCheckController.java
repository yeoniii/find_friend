package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.Member;
import mini.service.MemberService;
import mini.serviceImpl.MemberServiceImpl;

public class IdDuplicationCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService memberService = MemberServiceImpl.getInstance();

		try {
			String memberId = req.getParameter("memberId");
			String schoolName = req.getParameter("schoolName");
			String schoolNo = req.getParameter("schoolNo");
			
			Member member = memberService.checkIdDuplicate(memberId);
			if(member != null) { //id가 중복되는 회원이 있는 경우
				if(schoolName =="") {
					schoolName = " ";
				}
				if(schoolNo == "") {
					schoolNo = " ";
				}
				throw new Exception(schoolName+","+schoolNo);
			}else { //id가 중복되는 회원이 없는 경우
				req.setAttribute("schoolName", schoolName);
				req.setAttribute("schoolNo", schoolNo);
				req.setAttribute("memberId", memberId);
				req.setAttribute("checkId", false);
				req.getRequestDispatcher("/signup/registerMember.jsp").forward(req, resp);
			}
		} catch (Exception e) { // id가 중복되는 회원이 있는 경우
			String[] eMsg = e.getMessage().split(",");
			req.setAttribute("schoolName", eMsg[0]);
			req.setAttribute("schoolNo", eMsg[1]);
			req.setAttribute("checkId", true);
			req.getRequestDispatcher("/signup/registerMember.jsp").forward(req, resp);
		}
	}
}
