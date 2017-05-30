package mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.VO.Reply;
import mini.service.ReplyService;
import mini.serviceImpl.ReplyServiceImpl;

public class ReplySelectController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		ReplyService replyService = ReplyServiceImpl.getInstance();
		List<Reply> replyList = replyService.selectReplyByBoardNo(boardNo);
		
		request.setAttribute("replyList", replyList);
		request.getRequestDispatcher("/replyList.jsp").forward(request, response);
	}
}
