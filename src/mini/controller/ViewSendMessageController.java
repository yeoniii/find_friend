package mini.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.VO.Message;
import mini.serviceImpl.MessageServiceImpl;

public class ViewSendMessageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Message msg = new Message();
		MessageServiceImpl msi =  MessageServiceImpl.getInstance();
		HashMap<String, Object> map = new HashMap<>();

		try{
			HttpSession session=req.getSession();

			map.put("message_no", req.getParameter("message_no"));
			map.put("id", ((Member)session.getAttribute("member")).getMemberId());

			msg = msi.viewSendMsg(map);
			session.setAttribute("messageInfo", msg);

			session.setAttribute("memName", msg.getMember().getMemberName());

			req.getRequestDispatcher("/messagejsp/view_sendMessage.jsp").forward(req, resp);
			
		}catch(Exception e){
		
		}
	}
}
