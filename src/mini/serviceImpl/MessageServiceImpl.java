package mini.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.DaoImpl.MessageDaoImpl;
import mini.VO.Message;
import mini.service.MessageService;
import mini.util.SqlSessionFactoryManager;

public class MessageServiceImpl implements MessageService{

	public static MessageServiceImpl instance = new MessageServiceImpl();
	public static MessageServiceImpl getInstance(){
		return instance;
	}
	private MessageServiceImpl(){}
	
	
	@Override
	public void insertReplyMessage(int messageNo, Date sendDate, String title, String content, int messageState, String sendId, String receiveId){
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			
			dao.insertReplyMessage(sqlsession, new Message(messageNo, sendDate, title, content, messageState, sendId, receiveId));
			
			sqlsession.commit();
		}catch(Exception e){
			
		} finally {
			sqlsession.close();
		}
		
	}

	@Override
	public List<Message> getSendMessage(String id){
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		List<Message> list = new ArrayList<>();
		List<Message> notRemove = new ArrayList<>();
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			list=dao.selectSendMessage(sqlsession, id);
			
			for(Message m : list){
				if(m.getMessageState() != 2){ //보낸 사람이 삭제
					notRemove.add(m);
				}
			}			
			
			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		return notRemove;
	}
	
	
	@Override
	public List<Message> getReceiveMessage(String id) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		List<Message> list = new ArrayList<>();
		List<Message> notRemove = new ArrayList<>();
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			list=dao.selectReceiveMessage(sqlsession, id);
		
			for(Message m : list){
				if(m.getMessageState() != 3){ //받은 사람이 삭제
					notRemove.add(m);
				}
			}	

			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		return notRemove;
	}
	
	@Override
	public List<Message> getMessageByName(HashMap map) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		List<Message> list = new ArrayList<>();
		List<Message> notRemove = new ArrayList<>();
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			list=dao.selectMessageByName(sqlsession, map);
			for(Message m : list){
				if(m.getMessageState() != 3){
					notRemove.add(m);
				}
			}	
			
			sqlsession.commit();
		}catch(Exception e){

		}finally {
			sqlsession.close();
		}
		return notRemove;
	}
	
	@Override
	public List<Message> getMessageByTitle(HashMap map) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		List<Message> list = new ArrayList<>();
		List<Message> notRemove = new ArrayList<>();
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			list=dao.selectReceiveByTitle(sqlsession, map);
		
			for(Message m : list){
				if(m.getMessageState() != 3){
					notRemove.add(m);
				}
			}	

			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		return notRemove;
	}
	
	@Override
	public List<Message> getMessageByContent(HashMap map) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		List<Message> list = new ArrayList<>();
		List<Message> notRemove = new ArrayList<>();
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			list=dao.selectReceiveByContent(sqlsession, map);
		
			for(Message m : list){
				if(m.getMessageState() != 3){
					notRemove.add(m);
				}
			}	

			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		return notRemove;
	}
	
	@Override
	public void updateMessageState(HashMap map) {

		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			dao.updateMsgState(sqlsession, map);
		
			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		
	}

	@Override
	public Message viewReceiveMsg(HashMap map) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		Message msg = new Message();

		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			msg=dao.viewReceiveMsg(sqlsession, map);
		
			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		return msg;
	}
	
	@Override
	public Message viewSendMsg(HashMap map) {

		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		Message msg = new Message();
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			msg=dao.viewSendMsg(sqlsession, map);
		
			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
		return msg;
	}
	
	@Override
	public void deleteSendMessage(HashMap map) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			dao.deleteSendMessage(sqlsession, map);
		
			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public void deleteReceiveMessage(HashMap map) {
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			dao.deleteReceiveMessage(sqlsession, map);
		
			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
	}
	

	@Override
	public void setMessage(int messageNo, Date sendDate, String title, String content, int messageState, String sendId, String receiveId){
		
		MessageDaoImpl dao =  MessageDaoImpl.getInstance();
		SqlSession sqlsession = null;
		try {
			sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			
			int i =dao.insertMessage(sqlsession, new Message(messageNo, sendDate, title, content, messageState, sendId, receiveId));

			sqlsession.commit();
		}catch(Exception e){
			
		}finally {
			sqlsession.close();
		}
	}
	

	   @Override
	   public List<Message> getSendMessageByName(HashMap map) {
	      
	      MessageDaoImpl dao =  MessageDaoImpl.getInstance();
	      SqlSession sqlsession = null;
	      List<Message> list = new ArrayList<>();
	      List<Message> notRemove = new ArrayList<>();

	      try {
	         sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
	         list=dao.selectSendMessageByName(sqlsession, map);
	         
	         for(Message m : list){
	            if(m.getMessageState() != 3){
	               notRemove.add(m);
	            }
	         }   

	         sqlsession.commit();
	      }catch(Exception e){

	      }finally {
	         sqlsession.close();
	      }
	      return notRemove;
	   }
	   
	   @Override
	   public List<Message> getSendMessageByTitle(HashMap map) {
	      
	      MessageDaoImpl dao =  MessageDaoImpl.getInstance();
	      SqlSession sqlsession = null;
	      List<Message> list = new ArrayList<>();
	      List<Message> notRemove = new ArrayList<>();
	      
	      try {
	         sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
	         list=dao.selectSendReceiveByTitle(sqlsession, map);

	         for(Message m : list){
	            if(m.getMessageState() != 3){
	               notRemove.add(m);
	            }
	         }   

	         sqlsession.commit();
	      }catch(Exception e){
	         
	      }finally {
	         sqlsession.close();
	      }
	      return notRemove;
	   }
	   
	   @Override
	   public List<Message> getSendMessageByContent(HashMap map) {
	      
	      MessageDaoImpl dao =  MessageDaoImpl.getInstance();
	      SqlSession sqlsession = null;
	      List<Message> list = new ArrayList<>();
	      List<Message> notRemove = new ArrayList<>();
	      
	      try {
	         sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
	         list=dao.selectSendReceiveByContent(sqlsession, map);
	      
	         for(Message m : list){
	            if(m.getMessageState() != 3){
	               notRemove.add(m);
	            }
	         }   

	         sqlsession.commit();
	      }catch(Exception e){
	         
	      }finally {
	         sqlsession.close();
	      }
	      return notRemove;
	   }
}
