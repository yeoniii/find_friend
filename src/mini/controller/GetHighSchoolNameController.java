package mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.HighSchool;
import mini.service.HighSchoolService;
import mini.serviceImpl.HighSchoolServiceImpl;

public class GetHighSchoolNameController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			String memberEmail = req.getParameter("memberEmail");
			String memberId = req.getParameter("memberId");
			String schoolName = req.getParameter("schoolName");
			String schoolNo = req.getParameter("schoolNo");
			
			HighSchoolService service = HighSchoolServiceImpl.getInstance();
			List<HighSchool> list = service.selectHighSchool(schoolName);
			
			
			
			if(list == null) {	//해당되는 학교가 없는 경우
				throw new Exception(schoolName+","+schoolNo+","+memberId+","+memberEmail);
			}else { //해당되는 학교가 있는 경우
				req.setAttribute("memberId", memberId);
				req.setAttribute("memberEmail", memberEmail);
				req.setAttribute("schoolNo", schoolNo);
				req.setAttribute("schoolName", schoolName);
				req.setAttribute("schoolList", list);
				req.getRequestDispatcher("/schoolFind.jsp").forward(req, resp);
			}
		}catch(Exception e) {
			String[] eMsg = e.getMessage().split(",");
			req.setAttribute("schoolName", eMsg[0]);
			req.setAttribute("schoolNo", eMsg[1]);
			req.setAttribute("memberId", eMsg[2]);
			req.setAttribute("memberEmail", eMsg[3]);
			req.setAttribute("checkSchool", false);
			req.getRequestDispatcher("/registerMember.jsp").forward(req, resp);
		}
	}

	
}
