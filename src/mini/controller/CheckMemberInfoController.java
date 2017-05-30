package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMemberInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId=req.getParameter("id");
		String memberName=req.getParameter("name");
		
		req.setAttribute("receiveMemberId", memberId);
		req.setAttribute("receiveMemberName", memberName);
	
		req.getRequestDispatcher("/messagejsp/send_msg_form.jsp").forward(req, resp);
		
	}
	
	
}
