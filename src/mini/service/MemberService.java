package mini.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import mini.VO.Member;

public interface MemberService {
	/**
	 *  input 입력값으로 동창 찾아주는 메소드
	 * @param memberName
	 * @param graduateYear
	 * @param schoolName
	 * @param memberGender
	 * @return
	 * @throws IOException
	 */
	List<Member> foundMemberBySearch(String memberName, int graduateYear, String schoolName, char memberGender) throws IOException;
	/**
	 * page 기준으로 obejct(member)들을 조회하는 메소드
	 * @param page  보려는 페이지
	 * @return 
	 */
	Map<String, Object> getMemberList(int page, String memberName, int graduateYear, String schoolName, char memberGender);


	void insertMember(Member member);
	
	void updateMember(Member member);
	
	Member loginCheck(String memberId, String memberPassword) throws SQLException;
	
	Member selectMemberById(String memberId) throws SQLException;
	
	Member selectMemberByEmail(String memberEmail) throws SQLException;

	Member selectMemberByIdAndEmail(String memberId, String memberEmail) throws SQLException;

	void deleteMember(String loginId);
	
	Member checkIdDuplicate(String memberId);
	
	Member checkEmailDuplicate(String memberEmail);
}

