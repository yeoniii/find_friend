package mini.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.VO.Member;
import mini.VO.Message;
import mini.serviceImpl.MessageServiceImpl;

public class SearchMessageSendController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//text에 입력된값과 선택한 옵션값 같이 들고가서 map/req 이용 -> mapper가서 찾기 & 다시 여기와서 삭제 된거 아닌지 확인 필요	
		
		List<Message> list = new ArrayList<>();
		MessageServiceImpl msi =  MessageServiceImpl.getInstance();
		String[] opt = req.getParameterValues("search_opt");
		HashMap<String, Object> map = new HashMap<>();
		
		try{
			HttpSession session=req.getSession();

			map.put("text", req.getParameter("search"));
			map.put("id", ((Member)session.getAttribute("member")).getMemberId());
			map.put("opt", opt[0]);
			
			if(opt[0].equals("name")){
				list = msi.getSendMessageByName(map);
			}else if(opt[0].equals("title")){
				list = msi.getSendMessageByTitle(map);
			}else if(opt[0].equals("content")){
				list = msi.getSendMessageByContent(map);
			}
			session.setAttribute("researchInfo", list);
			session.setAttribute("find", map);

			req.getRequestDispatcher("/messagejsp/search_msg_send_result.jsp").forward(req, resp);
			
			
		}catch(Exception e){
		
		}
		
	}
}
