package mini.DaoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.Dao.HighSchoolDao;
import mini.VO.HighSchool;

public class HighSchoolDaoImpl implements HighSchoolDao {
	private static HighSchoolDaoImpl instance;
	private HighSchoolDaoImpl(){}
	public static HighSchoolDaoImpl getInstance() {
		if(instance == null) instance = new HighSchoolDaoImpl();
		return instance;
	}
	
	private String makeSqlId(String id) {
		return "mini.mapper.highSchoolMapper."+id;
	}
	
	@Override
	public List<HighSchool> selectHighSchool(SqlSession session, String schoolName) {
		return session.selectList(makeSqlId("selectHighSchool"), schoolName);
	}
	
	@Override
	public HighSchool selectHighSchoolBySchoolNo(SqlSession session, int schoolNo) {
		return session.selectOne(makeSqlId("selectHighSchoolByNo"), schoolNo);
	}
	
	
}
