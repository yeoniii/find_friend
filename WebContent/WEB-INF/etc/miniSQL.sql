/* 쪽지 관리 */
DROP TABLE MESSAGE
CREATE TABLE MESSAGE (
	MESSAGE_NO NUMBER(5) PRIMARY KEY, /* 쪽지번호 */
	SEND_DATE DATE NOT NULL, /* 날짜 */
	TITLE VARCHAR2(50) NOT NULL, /* 제목 */
	CONTENT VARCHAR2(200) NOT NULL, /* 내용 */
	MESSAGE_STATE NUMBER NOT NULL, /* 쪽지상태 */
	SEND_ID VARCHAR2(30) CONSTRAINT SEND_ID_FK REFERENCES MEMBER(MEMBER_ID), /* 보낼아이디 */
	RECEIVE_ID VARCHAR2(30) CONSTRAINT RECEIVE_ID_FK REFERENCES MEMBER(MEMBER_ID) /* 받은아이디 */
);

select * from MESSAGE ;

DROP SEQUENCE MESSAGE_NO_SEQ;
CREATE SEQUENCE MESSAGE_NO_SEQ;


/* 회원 관리 */
DROP TABLE MEMBER
CREATE TABLE MEMBER (
	MEMBER_ID VARCHAR2(30) PRIMARY KEY, /* 회원아이디 */
	MEMBER_PASSWORD VARCHAR2(30) NOT NULL, /* 회원비밀번호 */
	MEMBER_NAME VARCHAR2(20) NOT NULL, /* 회원이름 */
	GRADUATE_YEAR NUMBER(4) NOT NULL, /* 회원나이 */
	MEMBER_EMAIL VARCHAR2(50) UNIQUE, /* 회원이메일 */
	MEMBER_GENDER CHAR(1) NOT NULL, /* 회원성별 */
	SCHOOL_NO NUMBER CONSTRAINT SCH_NO_FK REFERENCES HIGHSCHOOL /* 학교번호 */
);

/* 고등학교 */
DROP TABLE HIGHSCHOOL
CREATE TABLE HIGHSCHOOL (
	SCHOOL_NO NUMBER PRIMARY KEY, /* 학교번호 */
	SCHOOL_NAME VARCHAR2(100) NOT NULL, /* 학교명 */
	ADDRESS VARCHAR2(200) NOT NULL, /* 지번주소 */
	ROAD_ADDRESS VARCHAR2(200) /* 도로명주소 */
);

DROP SEQUENCE school_num_seq;
CREATE SEQUENCE school_num_seq;

DROP TABLE board;
CREATE TABLE board(
	board_no number primary key,
	board_title varchar2(50) not null,
	board_content varchar2(200) not null,
	board_date date not null,
	board_hits number not null,
	member_id varchar2(30) not null
);

DROP sequence board_no_seq;
CREATE sequence board_no_seq;

select board_no_seq.nextval from dual

DROP TABLE reply;
CREATE TABLE reply (
	reply_no number,
	reply_content varchar2(100) not null,
	reply_date date not null,
	board_no number,
	member_id varchar2(30),
	constraint reply_pk primary key(reply_no),
	constraint reply_board_fk foreign key(board_no) references board ON delete cascade,
	constraint reply_member_fk foreign key(member_id) references member on delete cascade
);

DROP sequence reply_no_seq;
CREATE sequence reply_no_seq;






		SELECT school_no, school_name, address, road_address
		FROM highschool
		WHERE school_name LIKE '%'||'동백'||'%'
		
			SELECT message_no, send_date, title, content, message_state, send_id, receive_id
	FROM message
	WHERE receive_id = 'yt'
	ORDER BY message_no DESC 
	
	
		SELECT s.message_no, s.send_date, s.title, s.content, s.message_state, s.send_id, s.receive_id, m.member_name
	FROM message s JOIN member m ON s.receive_id = m.member_id
	WHERE s.receive_id = 'dufla' AND m.member_name LIKE '%'||'여'||'%'
	ORDER BY s.message_no DESC
	
	
	SELECT s.message_no, s.send_date, s.title, s.content, s.message_state, s.send_id, s.receive_id, m.member_name
	FROM message s JOIN member m ON s.send_id = m.member_id
	WHERE s.receive_id = 'yeorim' AND m.member_name LIKE '%'||'규'||'%'
	ORDER BY s.message_no DESC
	
	
	SELECT s.message_no, s.send_date, s.title, s.content, s.message_state, s.send_id, s.receive_id, m.member_name
	FROM message s JOIN member m ON s.send_id = m.member_id
	WHERE s.receive_id = 'yeorim' AND title LIKE '%'||'누구'||'%'
	ORDER BY s.message_no DESC
	
	SELECT s.message_no, s.send_date, s.title, s.content, s.message_state, s.send_id, s.receive_id, m.member_name
	FROM message s JOIN member m ON s.send_id = m.member_id
	WHERE s.receive_id = 'seyeon' AND title LIKE '%'||'안'||'%'
	ORDER BY s.message_no DESC
	
	
	SELECT s.message_no, s.send_date, s.title, s.content, s.message_state, s.send_id, s.receive_id, m.member_name
	FROM message s JOIN member m ON s.receive_id = m.member_id
	WHERE s.send_id = 'yeorim' AND title LIKE '%'||'안'||'%'
	ORDER BY s.message_no DESC