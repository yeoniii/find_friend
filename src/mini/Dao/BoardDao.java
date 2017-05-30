package mini.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.VO.Board;

public interface BoardDao {
	
	//게시글 1개를 등록하는 메소드
	int insertBoard(SqlSession session, Board board);
	
	//매개변수로 받은 board의 boardNo가 일치하는 게시글의 정보를 수정하는 메소드
	int updateBoard(SqlSession session, Board board);
	
	//매개변수로 받은 boardNo가 일치하는 게시글을 삭제하는 메소드
	int deleteBoard(SqlSession session, int boardNo);
	
	//조회수 조회하는 메소드
	int selectHits(SqlSession session);
	
	//모든 게시글들을 조회하는 메소드
	List<Board> selectAllBoard(SqlSession session, int beginItemNo, int endItemNo);
	
	//매개변수로 받은 문자열이 제목, 내용, id인지 구별해서 조회하는 메소드
	List<Board> selectBoardByMethod(SqlSession session, String method, String methodContent, int beginItemNo, int endItemNo);

	//게시글들의 개수 조회하는 메소드
	int selectItemCount(SqlSession session);
	
	int selectItemCountByMethod(SqlSession session, String method, String methodContent);
	
	//내가 작성한 게시글들을 조회하는 메소드
	List<Board> selectBoardMine(SqlSession session, String writer, int beginItemNo, int endItemNo);
	
	Board selectBoardByBoardNo(SqlSession session, int boardNo);
}