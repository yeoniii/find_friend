package mini.DaoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.Dao.MemberDao;
import mini.VO.Member;

public class MemberDaoImpl implements MemberDao{
	//싱글톤
		private static MemberDaoImpl instance;
		private MemberDaoImpl(){}
		public static MemberDaoImpl getInstance() {
			if(instance == null) instance = new MemberDaoImpl();
			return instance;
		}
		
	@Override
	public List<Member> selectMemberByAll(SqlSession sqlsession, String schoolName, char memberGender, int graduateYear,
			String memberName) {
		
		HashMap<String,Object> param=new HashMap<>();
		param.put("schoolName", schoolName);
		param.put("memberGender", memberGender);
		param.put("graduateYear",graduateYear);
		param.put("memberName", memberName);

		return sqlsession.selectList("mini.mapper.MemberMapper.selectMemberByAll",param);
	}
	// 싱글
	@Override
	public int selectMemberCountBySerch(SqlSession sqlsession, String schoolName, char memberGender, int graduateYear,
			String memberName) {
		HashMap<String,Object> param=new HashMap<>();
		param.put("schoolName", schoolName);
		param.put("memberGender", memberGender);
		param.put("graduateYear",graduateYear);
		param.put("memberName", memberName);
		
		return sqlsession.selectOne("mini.mapper.MemberMapper.selectMemberCountBySearch",param);
	}
	@Override
	public List<Member> selectMemberListPaging(SqlSession sqlsession, String schoolName, char memberGender,
			int graduateYear, String memberName, int startIndex, int endIndex) {
		HashMap<String,Object> param=new HashMap<>();
		param.put("schoolName", schoolName);
		param.put("memberGender", memberGender);
		param.put("graduateYear",graduateYear);
		param.put("memberName", memberName);
		param.put("startIndex",startIndex);
		param.put("endIndex", endIndex);
		
		return sqlsession.selectList("mini.mapper.MemberMapper.selectMemberListPaging",param);
		}
	
	
	private String makeSqlId(String id){
		return "mini.mapper.MemberMapper."+id;
	}
	
	/**
	 * 회원 추가
	 */
	@Override
	public int insertMember(SqlSession session, Member member) {
		return session.insert(makeSqlId("insertMember"),member);
	}
	
	/**
	 * 회원 삭제 메소드
	 * 매개변수 id로 받은것을 삭제 처리
	 */
	@Override
	public int deleteMemberById(SqlSession session, String id) throws SQLException {
		return session.delete(makeSqlId("deleteMember"),id);
	}
	
	/**
	 * 회원 정보 수정
	 */
	@Override
	public int updateMember(SqlSession session, Member member)  {
		return session.update(makeSqlId("updateMember"),member);
	}
	
	/**
	 * ID로 검색하여 회원을 조회 
	 */
	@Override
	public Member selectMemberById(SqlSession session, String id) throws SQLException {
		return session.selectOne(makeSqlId("selectMemberById"),id);
	}
	
	/**
	 * 모든 회원정보를 조회
	 */
	@Override
	public List<Member> selectMemberList (SqlSession session) throws SQLException {
		return session.selectList(makeSqlId("selectMemberList"));
	}
	
	/**
	 * 등록된 회원 중 이름으로 찾기
	 * 중복된 이름 발생으로 List사용
	 */
	@Override
	public List<Member> selectMemberByName(SqlSession session, String memberName) throws SQLException {
		return session.selectList(makeSqlId("selectMemberByName"));
	}
	
	/**
	 * 로그인 체크
	 */
	@Override
	public Member selectMemberByIdAndPwd(SqlSession session, String memberId, String memberPassword)throws SQLException {
		HashMap<String, Object> map = new HashMap<>();
		map.put("loginId", memberId);
		map.put("loginPwd", memberPassword);
		return session.selectOne(makeSqlId("selectMemberByIdAndPwd"), map);
	}
	
	/**
	 * 이메일로 회원 찾기 (아이디 찾기용)
	 */
	@Override
	public Member selectMemberByEmail(SqlSession session, String memberEmail) throws SQLException {
		return session.selectOne(makeSqlId("selectMemberByEmail"), memberEmail);
	}
	
	/**
	 * 아이디와 이메일로 회원 찾기 (비밀번호 찾기용)
	 */
	@Override
	public Member selectMemberByIdAndEmail(SqlSession session, String memberId, String memberEmail) throws SQLException {
		HashMap<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("memberEmail", memberEmail);
		return session.selectOne(makeSqlId("selectMemberByIdAndEmail"), map);
	}

	/**
	 * 회원 정보 삭제
	 */
	@Override
	public int deleteMember(SqlSession session, String loginId) {
		return session.delete(makeSqlId("deleteMember"), loginId);
	}

	/**
	 * 회원 아이디 중복 체크
	 */
	@Override
	public Member checkIdDuplicate(SqlSession session, String memberId) {
		return session.selectOne(makeSqlId("checkIdDuplicate"), memberId);
	}
	
	/**
	 * 회원 이메일 중복 체크
	 */
	@Override
	public Member checkEmailDuplicate(SqlSession session, String memberEmail) {
		return session.selectOne(makeSqlId("checkEmailDuplicate"), memberEmail);
	}
	
	
	}

	
	
	

