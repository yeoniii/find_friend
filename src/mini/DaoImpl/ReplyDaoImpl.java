package mini.DaoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.Dao.ReplyDao;
import mini.VO.Reply;

public class ReplyDaoImpl implements ReplyDao {
	
	private static ReplyDaoImpl instance;
	private ReplyDaoImpl(){}
	
	public static ReplyDaoImpl getInstance() {
		if(instance == null) instance = new ReplyDaoImpl();
		return instance;
	}
	
	private String makeSqlId(String id) {
		return "mini.mapper.replyMapper."+id;
	}
	
	@Override
	public int insertReply(SqlSession session, Reply reply) {
		return session.insert(makeSqlId("insertReply"), reply);
	}
	
	@Override
	public int updateReply(SqlSession session, Reply reply) {
		return session.update(makeSqlId("updateReply"), reply);
	}
	
	@Override
	public int deleteReply(SqlSession session, int replyNo) {
		return session.delete(makeSqlId("deleteReply"), replyNo);
	}
	
	@Override
	public List<Reply> selectAllReply(SqlSession session, int boardNo) {
		return session.selectList(makeSqlId("selectReplyByBoardNo"), boardNo);
	}
	
	@Override
	public List<Reply> selectReplyByMemberId(SqlSession session, String memberId) {
	
		return null;
	}

	@Override
	public List<Integer> selectReplyCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList(makeSqlId("selectReplyCount"));
	}	
}