package mini.VO;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	private int messageNo;
	private Date sendDate;
	private String title;
	private String content;
	private int messageState;
	private String sendId;
	private String receiveId;
	private Member member;
	
	public Message(){}
	
	public Message(int messageNo, Date sendDate, String title, String content, int messageState, String sendId,
			String receiveId) {
		super();
		this.messageNo = messageNo;
		this.sendDate = sendDate;
		this.title = title;
		this.content = content;
		this.messageState = messageState;
		this.sendId = sendId;
		this.receiveId = receiveId;
	}

	public Message(int messageNo, Date sendDate, String title, String content, int messageState, String sendId,
			String receiveId, Member member) {
		super();
		this.messageNo = messageNo;
		this.sendDate = sendDate;
		this.title = title;
		this.content = content;
		this.messageState = messageState;
		this.sendId = sendId;
		this.receiveId = receiveId;
		this.member = member;
	}

	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMessageState() {
		return messageState;
	}

	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + messageNo;
		result = prime * result + messageState;
		result = prime * result + ((receiveId == null) ? 0 : receiveId.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((sendId == null) ? 0 : sendId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (messageNo != other.messageNo)
			return false;
		if (messageState != other.messageState)
			return false;
		if (receiveId == null) {
			if (other.receiveId != null)
				return false;
		} else if (!receiveId.equals(other.receiveId))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (sendId == null) {
			if (other.sendId != null)
				return false;
		} else if (!sendId.equals(other.sendId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", sendDate=" + sendDate + ", title=" + title + ", content="
				+ content + ", messageState=" + messageState + ", sendId=" + sendId + ", receiveId=" + receiveId
				+ ", member=" + member + "]";
	}
	
	
}
