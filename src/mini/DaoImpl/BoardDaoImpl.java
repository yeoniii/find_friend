package mini.DaoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.Dao.BoardDao;
import mini.VO.Board;

public class BoardDaoImpl implements BoardDao {
	private static BoardDaoImpl instance;
	private BoardDaoImpl(){}
	public static BoardDaoImpl getInstance() {
		if(instance == null) instance = new BoardDaoImpl();
		return instance;
	}
	
	private String makeSqlId(String id) {
		return "mini.mapper.boardMapper."+id;
	}
	
	//게시글 1개를 등록하는 메소드
	@Override
	public int insertBoard(SqlSession session, Board board) {
		int cnt = session.insert(makeSqlId("insertBoard"), board);
		return board.getBoardNo();
	}
	
	//매개변수로 받은 board의 boardNo가 일치하는 게시글의 정보를 수정하는 메소드
	@Override
	public int updateBoard(SqlSession session, Board board) {
		return session.update(makeSqlId("updateBoard"), board);
	}
	
	//매개변수로 받은 boardNo가 일치하는 게시글을 삭제하는 메소드
	@Override
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete(makeSqlId("deleteBoard"), boardNo);
	}
	
	//조회수 조회하는 메소드
	@Override
	public int selectHits(SqlSession session) {
		return 0;
	}
	
	//모든 게시글들을 조회하는 메소드
	@Override
	public List<Board> selectAllBoard(SqlSession session, int beginItemNo, int endItemNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("beginItemNum", beginItemNo);
		map.put("endItemNum", endItemNo);
		return session.selectList(makeSqlId("selectAllBoard"), map);
	}
	
	//매개변수로 받은 문자열이 제목, 내용, id인지 구별해서 조회하는 메소드
	@Override
	public List<Board> selectBoardByMethod(SqlSession session, String method, String methodContent, int beginItemNo, int endItemNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("method", method);
		map.put("methodContent", methodContent);
		map.put("beginItemNum", beginItemNo);
		map.put("endItemNum", endItemNo);
		return session.selectList(makeSqlId("selectBoardByMethod"), map);
	}
	
	//게시글들의 개수 조회하는 메소드
	@Override
	public int selectItemCount(SqlSession session) {
		return session.selectOne(makeSqlId("selectItemCount"));
	}
	
	public int selectItemCountByMethod(SqlSession session, String method, String methodContent) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("method", method);
		map.put("methodContent", methodContent);
		return session.selectOne(makeSqlId("selectItemCountByMethod"), map);
	}
	
	//내가 작성한 게시글들을 조회하는 메소드
	@Override
	public List<Board> selectBoardMine(SqlSession session, String writer, int beginItemNo, int endItemNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("writer", writer);
		map.put("beginItemNum", beginItemNo);
		map.put("endItemNum", endItemNo);
		return session.selectList(makeSqlId("selectMyBoard"), map);
	}
	
	public Board selectBoardByBoardNo(SqlSession session, int boardNo) {
		return session.selectOne(makeSqlId("selectBoardByBoardNo"), boardNo);
	}
}