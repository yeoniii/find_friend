package mini.service;

import java.util.List;

import mini.VO.HighSchool;

public interface HighSchoolService {
	List<HighSchool> selectHighSchool(String schoolName);
	
	HighSchool selectHighSchoolBySchoolNo(int schoolNo);
}
