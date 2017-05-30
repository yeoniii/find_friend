package mini.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini.Dao.HighSchoolDao;
import mini.DaoImpl.HighSchoolDaoImpl;
import mini.VO.HighSchool;
import mini.service.HighSchoolService;
import mini.util.SqlSessionFactoryManager;

public class HighSchoolServiceImpl implements HighSchoolService {
	private SqlSessionFactory factory;
	private	HighSchoolDao dao;
	
	private static HighSchoolService instance;
	
	private HighSchoolServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = HighSchoolDaoImpl.getInstance();
	}
	
	public static HighSchoolService getInstance() throws IOException {
		if(instance == null) {
			instance = new HighSchoolServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<HighSchool> selectHighSchool(String schoolName) {
		HashMap<String, Object> map = new HashMap<>();
		SqlSession session = factory.openSession();

		List<HighSchool> list = dao.selectHighSchool(session, schoolName);
		return list;
	}

	@Override
	public HighSchool selectHighSchoolBySchoolNo(int schoolNo) {
		SqlSession session = factory.openSession();
		
		HighSchool highSchool = dao.selectHighSchoolBySchoolNo(session, schoolNo);
		return highSchool;
	}

}
