package mini.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import mini.VO.Message;

public interface MessageService {

	/**
	 * message 보내기
	 * @param messageNo
	 * @param sendDate
	 * @param title
	 * @param content
	 * @param messageState
	 * @param sendId
	 * @param receiveId
	 */
	void insertReplyMessage (int messageNo, Date sendDate, String title, String content, int messageState, String sendId, String receiveId);
	
	/**
	 * 보낸 메세지 조회하기
	 * @return
	 */
	List<Message> getSendMessage(String id);
	
	/**
	 * 받은 메세지 조회하기
	 * @return
	 */
	List<Message> getReceiveMessage(String id);
	
	/**
	 * 이름으로 메세지 조회하기
	 * @return
	 */
	List<Message> getMessageByName(HashMap map);
	
	/**
	 * 제목으로 메세지 조회하기
	 * @return
	 */
	List<Message> getMessageByTitle(HashMap map);
	
	/**
	 * 내용으로 메세지 조회하기
	 * @return
	 */
	List<Message> getMessageByContent(HashMap map);
	
	/**
	 * 메세지 상태 update하기
	 */
	void updateMessageState(HashMap map);
	
	/**
	 * 받은 메세지 전체 내용 보기
	 * @return
	 */
	Message viewReceiveMsg(HashMap map);
	
	/**
	 * 보낸 메세지 전체 내용 보기
	 * @return
	 */
	Message viewSendMsg(HashMap map);
	
	/**
	 * 보낸 메세지 삭제하기
	 */
	void deleteSendMessage(HashMap map);
	
	/**
	 * 받은 메세지 삭제하기
	 */
	void deleteReceiveMessage(HashMap map);
	
	/**
	 * 쪽지보내기 - jsp로부터 받은 data를 Database로 넣기
	 * 
	 */
	void setMessage (int messageNo, Date sendDate, String title, String content, int messageState, String sendId, String receiveId);
	
	/**
	    * 보낸메세지함에서 이름으로 검색
	    * @param map
	    * @return
	    */
	   List<Message> getSendMessageByName(HashMap map);
	   
	   /**
	    *  보낸메세지함에서
	    * 제목으로 메세지 조회하기
	    * @return
	    */
	   List<Message> getSendMessageByTitle(HashMap map);
	   
	   /**
	    *  보낸메세지함에서
	    * 내용으로 메세지 조회하기
	    * @return
	    */
	   List<Message> getSendMessageByContent(HashMap map);
}
