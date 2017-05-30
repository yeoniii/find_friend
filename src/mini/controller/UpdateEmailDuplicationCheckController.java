package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.Member;
import mini.service.MemberService;
import mini.serviceImpl.MemberServiceImpl;

public class UpdateEmailDuplicationCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService memberService = MemberServiceImpl.getInstance();
		
		try {
			String memberEmail = req.getParameter("memberEmail");
			String memberId = req.getParameter("memberId");
			String schoolName = req.getParameter("schoolName");
			String schoolNo = req.getParameter("schoolNo");
			
			Member member = memberService.checkEmailDuplicate(memberEmail);

			if(member != null) { //email이 중복되는 회원이 있는 경우
				if(schoolName == "") {
					schoolName = " ";
				}
				if(schoolNo == "") {
					schoolNo = " ";
				}
				if(memberId == "") {
					memberId = " ";
				}
				throw new Exception(schoolName+","+schoolNo+","+memberId);
			}else { //email이 중복되는 회원이 없는 경우
				req.setAttribute("memberEmail", memberEmail);
				req.setAttribute("schoolName", schoolName);
				req.setAttribute("schoolNo", schoolNo);
				req.setAttribute("memberId", memberId);
				req.setAttribute("checkEmail", false);
				req.getRequestDispatcher("/updateMyInfo.jsp").forward(req, resp);
			}
		}catch(Exception e) { //email이 중복되는 회원이 있는 경우
			String[] eMsg = e.getMessage().split(",");
			req.setAttribute("schoolName", eMsg[0]);
			req.setAttribute("schoolNo", eMsg[1]);
			req.setAttribute("memberId", eMsg[2]);
			req.setAttribute("checkEmail", true);
			req.getRequestDispatcher("/updateMyInfo.jsp").forward(req, resp);
		}
	}
}

