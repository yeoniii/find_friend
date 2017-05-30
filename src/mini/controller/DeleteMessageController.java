package mini.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.serviceImpl.MessageServiceImpl;

public class DeleteMessageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MessageServiceImpl msi =  MessageServiceImpl.getInstance();
		HashMap<String, Object> map = new HashMap<>();

		try{
			HttpSession session=req.getSession();

			map.put("message_no", req.getParameter("msgNo"));
			map.put("id", ((Member)session.getAttribute("member")).getMemberId());

			if(req.getParameter("location").equals("send")){
				msi.deleteSendMessage(map);
			}else if(req.getParameter("location").equals("receive")){
				msi.deleteReceiveMessage(map);
			}
			

			req.getRequestDispatcher("/messagejsp/delete_success.jsp").forward(req, resp);
			
		}catch(Exception e){
		
		}
	}
}
