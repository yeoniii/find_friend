package mini.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.serviceImpl.MessageServiceImpl;

public class InsertReplyMessageController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		int messageNo = 0;
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Date sendDate = new Date();
		int messageState = 0;
		
		MessageServiceImpl msi =  MessageServiceImpl.getInstance();
		
		try{
			HttpSession session=req.getSession();
			
			String sendId = req.getParameter("sendId");
			String receiveId = req.getParameter("receiveId");
			
			msi.insertReplyMessage(messageNo, sendDate, title, content, messageState, sendId, receiveId);
			
			req.getRequestDispatcher("/messagejsp/reply_success.jsp").forward(req, resp);
			
		}catch(Exception e){
			
		}
		
		
	}

}
