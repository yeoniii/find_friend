package mini.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.VO.Reply;

public interface ReplyDao {
	
	//댓글 1개를 등록하는 메소드
	int insertReply(SqlSession session, Reply reply);
	
	//매개변수로 받은 reply의 replyNo가 일치하는 댓글의 정보를 수정하는 메소드
	int updateReply(SqlSession session, Reply reply);
	
	//매개변수로 받은 replyNo가 일치하는 댓글을 삭제하는 메소드
	int deleteReply(SqlSession session, int replyNo);
	
	//모든 댓글들을 조회하는 메소드
	List<Reply> selectAllReply(SqlSession session, int boardNo);
	
	//매개변수로 받은 memberId가 일치하는 댓글들을 조회하는 메소드
	List<Reply> selectReplyByMemberId(SqlSession session, String memberId);
	
	List<Integer> selectReplyCount(SqlSession session);
}