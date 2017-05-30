package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.service.MemberService;
import mini.serviceImpl.MemberServiceImpl;

public class FindLoginInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		MemberService memberService = MemberServiceImpl.getInstance();
		
		try {
			String infoKind = req.getParameter("infoKind");
			
			if(infoKind.equals("findId")) {
				String memberEmailForId = req.getParameter("memberEmail");
				
				Member member = memberService.selectMemberByEmail(memberEmailForId);
				
				if(member != null) { 
					req.setAttribute("resultIdByFinding", member.getMemberId());
					req.getRequestDispatcher("/login/findId.jsp").forward(req, resp);
				}else {
					throw new Exception("findId");
				}
			}else if(infoKind.equals("findPwd")){
				String memberIdForPwd = req.getParameter("memberId");
				String memberEmailForPwd = req.getParameter("memberEmail");
				
				Member member = memberService.selectMemberByIdAndEmail(memberIdForPwd, memberEmailForPwd);

				if(member != null) {
					req.setAttribute("resultPwdByFinding", member.getMemberPassword());
					req.getRequestDispatcher("/login/findPwd.jsp").forward(req, resp);
				}else {
					throw new Exception("findPwd");
				}
			}
			
		}catch(Exception e) {
			if(e.getMessage().equals("findId")) {
				req.setAttribute("findIdMsg", false); //해당 이메일을 가진 회원이 없는 경우
				req.getRequestDispatcher("/login/findId.jsp").forward(req, resp);
			}else if(e.getMessage().equals("findPwd")) {
				req.setAttribute("findPwdMsg", false);
				req.getRequestDispatcher("/login/findPwd.jsp").forward(req, resp);
			}
		}
	}
}
