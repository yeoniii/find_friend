package mini.service;

import java.util.List;

import mini.VO.Reply;

public interface ReplyService {
	
	void insertReply(Reply reply);
	
	void updateReply(Reply reply);
	
	void deleteReply(int replyNo);
	
	List<Reply> selectReplyByBoardNo(int boardNo);
	
	List<Integer> selectReplyCount();
}