package mini.DaoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.Dao.MessageDao;
import mini.VO.Message;

public class MessageDaoImpl implements MessageDao{
	public static MessageDaoImpl instance = new MessageDaoImpl();
	public static MessageDaoImpl getInstance(){
		return instance;
	}
	private MessageDaoImpl(){}
	
	@Override
	public int insertReplyMessage(SqlSession session, Message message) {
		return session.insert("mini.mapper.MessageMapper.insertReplyMessage",message);
	}
	@Override
	public List<Message> selectSendMessage(SqlSession session, String id) {
		return session.selectList("mini.mapper.MessageMapper.selectSendMessage", id);
	}
	@Override
	public List<Message> selectReceiveMessage(SqlSession session, String id) {
		return session.selectList("mini.mapper.MessageMapper.selectReceiveMessage", id);
	}
	@Override
	public List<Message> selectMessageByName(SqlSession session, HashMap map) {
		return session.selectList("mini.mapper.MessageMapper.selectMessageByName", map);
	}
	@Override
	public List<Message> selectReceiveByTitle(SqlSession session, HashMap map) {
		return session.selectList("mini.mapper.MessageMapper.selectReceiveByTitle", map);
	}
	@Override
	public List<Message> selectReceiveByContent(SqlSession session, HashMap map) {
		return session.selectList("mini.mapper.MessageMapper.selectReceiveByContent", map);
	}
	@Override
	public int updateMsgState(SqlSession session, HashMap map) {
		return session.update("mini.mapper.MessageMapper.updateMsgState", map);
	}
	@Override
	public Message viewReceiveMsg(SqlSession session, HashMap map) {
		return session.selectOne("mini.mapper.MessageMapper.viewReceiveMsg", map);
	}
	@Override
	public Message viewSendMsg(SqlSession session, HashMap map) {
		return session.selectOne("mini.mapper.MessageMapper.viewSendMsg", map);
	}
	@Override
	public int deleteSendMessage(SqlSession session, HashMap map) {
		return session.update("mini.mapper.MessageMapper.deleteSendMessage", map);
	}
	@Override
	public int deleteReceiveMessage(SqlSession session, HashMap map) {
		return session.update("mini.mapper.MessageMapper.deleteReceiveMessage", map);
	}
	@Override
	public int insertMessage(SqlSession sqlsession, Message message) {
		return sqlsession.insert("mini.mapper.MessageMapper.insertMessage",message);
	}
	@Override
	   public List<Message> selectSendMessageByName(SqlSession session, HashMap map) {
	      return session.selectList("mini.mapper.MessageMapper.selectSendMessageByName", map);
	   }
	   @Override
	   public List<Message> selectSendReceiveByTitle(SqlSession session, HashMap map) {
	      return session.selectList("mini.mapper.MessageMapper.selectSendReceiveByTitle", map);
	   }
	   @Override
	   public List<Message> selectSendReceiveByContent(SqlSession session, HashMap map) {
	      return session.selectList("mini.mapper.MessageMapper.selectSendReceiveByContent", map);
	   }
	
}
