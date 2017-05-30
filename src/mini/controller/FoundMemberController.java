package mini.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.Member;
import mini.service.MemberService;
import mini.serviceImpl.MemberServiceImpl;

public class FoundMemberController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		List<Member> list=new ArrayList<>();
		try{
		// 1.요청파라미터 읽기 시작
		int page = 1; // 기본 페이지가 1
		try{
		page=Integer.parseInt(req.getParameter("page")); // 
		}catch(Exception e){}
		
		String schoolName=req.getParameter("schoolName");
		String paramName=req.getParameter("memberName");
		int graduateYear=Integer.parseInt(req.getParameter("graduateYear"));
		
		String memberName="";  //default값
		if(!paramName.equals("")){
			memberName=req.getParameter("memberName");
		}else if(paramName.equals("")){
			memberName="";
		}
		
		char memberGender=req.getParameter("memberGender").charAt(0);
		
		
		// 2. 비즈니스 로직 
			MemberService service = MemberServiceImpl.getInstance();
			list = service.foundMemberBySearch(memberName, graduateYear, schoolName, memberGender);
			
			Map<String,Object>map = service.getMemberList(page,memberName,graduateYear,schoolName,memberGender);
			
		// 3. 결과 응답
			req.setAttribute("foundList", map.get("list"));
			req.setAttribute("pageBean", map.get("pageBean"));
			
			req.getRequestDispatcher("/foundjsp/view_found_result.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
