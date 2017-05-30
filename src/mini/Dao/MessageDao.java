package mini.Dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.VO.Message;

/**
 * Message 테이블 관련 SQL처리 Dao 인터페이스
 * @author YR
 *
 */
public interface MessageDao {
	/**
	 * message 보내기 (DB에 message 넣기)
	 * @param session
	 * @param message
	 * @return
	 */
	int insertReplyMessage (SqlSession session,Message message);
	
	/**
	 * 보낸 메세지 조회하기 (DB로부터 message 조회하기)
	 * @param session
	 * @return
	 */
	List<Message> selectSendMessage(SqlSession session, String id);
	
	/**
	 * 받은 메세지 조회하기 (DB로부터 message 조회하기)
	 * @param session
	 * @return
	 */
	List<Message> selectReceiveMessage(SqlSession session, String id);
	
	/**
	 * 이름으로 조회하기 (DB로부터 message 조회하기)
	 * @param session
	 * @return
	 */
	List<Message> selectMessageByName(SqlSession session, HashMap map);
	
	/**
	 * 제목으로 조회하기 (DB로부터 message 조회하기)
	 * @param session
	 * @return
	 */
	List<Message> selectReceiveByTitle(SqlSession session, HashMap map);
	
	/**
	 * 내용으로 조회하기 (DB로부터 message 조회하기)
	 * @param session
	 * @return
	 */
	List<Message> selectReceiveByContent(SqlSession session, HashMap map);
	
	/**
	 * 메세지 상태(읽음/읽지않음/삭제) update하기
	 */
	int updateMsgState(SqlSession session, HashMap map);
	
	/**
	 * 받은 메세지 전체 내용 확인하기
	 * @return
	 */
	Message viewReceiveMsg(SqlSession session, HashMap map);
	
	/**
	 * 보낸 메세지 전체 내용 확인하기
	 * @return
	 */
	Message viewSendMsg(SqlSession session, HashMap map);
	
	/**
	 * 보낸 메세지 삭제하기
	 * @return
	 */
	int deleteSendMessage(SqlSession session, HashMap map);
	
	/**
	 * 받은 메세지 삭제하기
	 * @return
	 */
	int deleteReceiveMessage(SqlSession session, HashMap map);
	
	/**
	 * DB에 message 넣기
	 * @param session
	 * @param message
	 * @return
	 */
	int insertMessage (SqlSession sqlsession,Message message);
	
	/**
	    * 이름으로 조회하기 (DB로부터 message 조회하기)
	    * @param session
	    * @return
	    */
	   List<Message> selectSendMessageByName(SqlSession session, HashMap map);
	   
	   /**
	    * 제목으로 조회하기 (DB로부터 message 조회하기)
	    * @param session
	    * @return
	    */
	   List<Message> selectSendReceiveByTitle(SqlSession session, HashMap map);
	   
	   /**
	    * 내용으로 조회하기 (DB로부터 message 조회하기)
	    * @param session
	    * @return
	    */
	   List<Message> selectSendReceiveByContent(SqlSession session, HashMap map);
}
