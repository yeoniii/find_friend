package mini.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini.Dao.ReplyDao;
import mini.DaoImpl.ReplyDaoImpl;
import mini.VO.Reply;
import mini.service.ReplyService;
import mini.util.SqlSessionFactoryManager;

public class ReplyServiceImpl implements ReplyService {
	
	private SqlSessionFactory factory;
	private ReplyDao dao;
	
	private static ReplyService instance;
	
	private ReplyServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = ReplyDaoImpl.getInstance();
	}
	
	public static ReplyService getInstance() throws IOException {
		if(instance == null) {
			instance = new ReplyServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void insertReply(Reply reply) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		try {
			dao.insertReply(session, reply);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateReply(Reply reply) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		try {
			dao.updateReply(session, reply);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteReply(int replyNo) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		try {
			dao.deleteReply(session, replyNo);
			session.commit();
		} finally {
			session.close();
		}
		
	}
	
	public List<Reply> selectReplyByBoardNo(int boardNo) {
		SqlSession session = factory.openSession();
		try {
			return dao.selectAllReply(session, boardNo);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Integer> selectReplyCount() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		try {
			return dao.selectReplyCount(session);
		} finally {
			session.close();
		}
	}
}
