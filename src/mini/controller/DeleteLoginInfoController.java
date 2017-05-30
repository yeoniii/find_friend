package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.service.MemberService;
import mini.serviceImpl.MemberServiceImpl;

public class DeleteLoginInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			String loginId = req.getParameter("LoginInfo");
			
			service.deleteMember(loginId);
			
			req.setAttribute("deleteMsg", false);
			req.getRequestDispatcher("/Homejsp/HP_HOME.jsp").forward(req, resp);;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
