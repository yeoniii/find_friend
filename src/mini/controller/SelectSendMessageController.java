package mini.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.VO.Message;
import mini.serviceImpl.MessageServiceImpl;

public class SelectSendMessageController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Message> list = new ArrayList<>();
		MessageServiceImpl msi =  MessageServiceImpl.getInstance();
		
		
		try{
			HttpSession session=req.getSession();

			list = msi.getSendMessage(((Member)session.getAttribute("member")).getMemberId());
			session.setAttribute("messageInfo", list);
			req.getRequestDispatcher("/messagejsp/select_sendMsg.jsp").forward(req, resp);
			
			
		}catch(Exception e){
		
		}
	}
}
