package mini.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mini.VO.Member;

public interface MemberDao {

	/**
	 * 학교이름, 성별, 졸업년도, 이름으로 검색해서 동창 찾아주는 메소드
	 * @param sqlsession
	 * @param schoolName
	 * @param memberGender
	 * @param graduateYear
	 * @param memberName
	 * @return
	 */
	List<Member> selectMemberByAll(SqlSession sqlsession, String schoolName, char memberGender, int graduateYear, String memberName);
	
	/**
	 * 매개변수 4개로 select 한 동창 수 반환
	 * @param sqlsession
	 * @return
	 */
	int selectMemberCountBySerch(SqlSession sqlsession, String schoolName, char memberGender, int graduateYear, String memberName);
	/**
	 * 페이징처리 위한 메소드
	 * @param sqlsession
	 * @param schoolName
	 * @param memberGender
	 * @param graduateYear
	 * @param memberName
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	List<Member> selectMemberListPaging(SqlSession sqlsession, String schoolName, char memberGender, int graduateYear, String memberName, int startIndex, int endIndex);


	// 회원 추가 메소드
		int insertMember(SqlSession session, Member member);
		
		// 회원 ID로 저장된 회원 삭제
		int deleteMemberById (SqlSession session, String memberId) throws SQLException;
		
		// 회원 정보 수정
		int updateMember(SqlSession session, Member member) ;
			
		// 저장된 회원 중 id로 조회
		Member selectMemberById(SqlSession session, String memberId) throws SQLException;
		
		// 저장된 회원 중 이름으로 조회
		List<Member> selectMemberByName(SqlSession session, String memberName) throws SQLException;
		
		// 저장된 모든  회원 조회
		List<Member> selectMemberList (SqlSession session) throws SQLException;
		
		// 로그인 체크
		Member selectMemberByIdAndPwd(SqlSession session, String memberId, String memberPassword) throws SQLException;

		// 이메일로 회원아이디 조회
		Member selectMemberByEmail(SqlSession session, String memberEmail) throws SQLException;
		
		//아이디와 이메일로 비밀번호 조회
		Member selectMemberByIdAndEmail(SqlSession session, String memberId, String memberEmail) throws SQLException;
		
		//회원 정보 삭제
		int deleteMember(SqlSession session, String loginId);
		
		// id 중복 체크
		Member checkIdDuplicate(SqlSession session, String memberId);
		
		// 이메일 중복 체크
		Member checkEmailDuplicate(SqlSession session, String memberEmail);




}
