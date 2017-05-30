package mini.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini.Dao.BoardDao;
import mini.DaoImpl.BoardDaoImpl;
import mini.VO.Board;
import mini.service.BoardService;
import mini.util.PagingBean;
import mini.util.SqlSessionFactoryManager;

public class BoardServiceImpl implements BoardService {
	private SqlSessionFactory factory;
	private BoardDao dao;
	
	private static BoardService instance;
	
	private BoardServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardService getInstance() throws IOException {
		if(instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}
	
	@Override
	public int insertBoard(Board board) {
		SqlSession session = factory.openSession();
		try {
			int cnt = dao.insertBoard(session, board);
			session.commit();
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateBoard(Board board) {
		SqlSession session = factory.openSession();
		try {
			dao.updateBoard(session, board);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteBoard(int boardNo) {
		SqlSession session = factory.openSession();
		try {
			dao.deleteBoard(session, boardNo);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void selectHits() {
		
	}

	@Override
	public HashMap<String, Object> selectBoard(int page) {
		HashMap<String, Object> map = new HashMap<>();
		SqlSession session = factory.openSession();
		
		//item 수
		int totalCount = dao.selectItemCount(session);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<Board> list = dao.selectAllBoard(session, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> selectBoardByMethod(int page, String method, String methodContent) {
		HashMap<String, Object> map = new HashMap<>();
		SqlSession session = factory.openSession();

		// item 수
		int totalCount = dao.selectItemCountByMethod(session, method, methodContent);

		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<Board> list = dao.selectBoardByMethod(session, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	@Override
	public HashMap<String, Object> selectBoardMine(int page, String writer) {
		HashMap<String, Object> map = new HashMap<>();
		SqlSession session = factory.openSession();
		
		// item 수
		int totalCount = dao.selectItemCountByMethod(session, "writer", writer);
		
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<Board> list = dao.selectBoardMine(session, writer, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
	
	public Board selectBoardByBoardNo(int boardNo) {
		SqlSession session = factory.openSession();
		return dao.selectBoardByBoardNo(session, boardNo);
	}
}