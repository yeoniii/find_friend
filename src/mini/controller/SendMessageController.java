package mini.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.serviceImpl.MessageServiceImpl;

public class SendMessageController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//요청 파라미터 읽기 시작
		int messageNo=0;
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		Date sendDate=new Date();
		int messageState = 0; // 읽지않음 상태로 보냄
		//String sendId=req.getParameter("memberId");  // !!!!!!!!!!!!! 로그인 안했을 경우 test- noId로 등록해놨었음
		HttpSession session = req.getSession();
		Member member  = (Member)session.getAttribute("member");
		String sendId = member.getMemberId();
		String receiveId=req.getParameter("receiveId"); // to
		
		
		MessageServiceImpl msgservice =  MessageServiceImpl.getInstance();
		
		try{
			msgservice.setMessage(messageNo, sendDate, title, content, messageState, sendId, receiveId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/messagejsp/sendComplete.jsp").forward(req, resp);
	}
}
