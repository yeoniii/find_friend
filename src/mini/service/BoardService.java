package mini.service;

import java.util.HashMap;
import java.util.List;

import mini.VO.Board;

public interface BoardService {
	
	int insertBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(int boardNo);
	
	//
	void selectHits();
	
	HashMap<String, Object> selectBoard(int page);
	
	HashMap<String, Object> selectBoardByMethod(int page, String method, String methodContent);
	
	HashMap<String, Object> selectBoardMine(int page, String writer);
	
	Board selectBoardByBoardNo(int boardNo);
}