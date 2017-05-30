package mini.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.VO.HighSchool;

public interface HighSchoolDao {
	List<HighSchool> selectHighSchool(SqlSession session, String schoolName);
	
	HighSchool selectHighSchoolBySchoolNo(SqlSession session, int schoolNo);

}

