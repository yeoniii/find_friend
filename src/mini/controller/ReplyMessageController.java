package mini.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReplyMessageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HashMap<String, Object> map = new HashMap<>();
		req.setCharacterEncoding("UTF-8");
		
		
		try{
			HttpSession session=req.getSession();

			map.put("sendDate", new Date());
			map.put("messageState", 0);
			map.put("sendId", req.getParameter("send_id"));
			map.put("receiveId", req.getParameter("receive_id"));
			map.put("recName", req.getParameter("rec_name"));
			
			session.setAttribute("replyInfo", map);
			req.getRequestDispatcher("/messagejsp/reply_message.jsp").forward(req, resp);
			
		}catch(Exception e){
			
		}
		
	}
}
