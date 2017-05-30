package mini.serviceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mini.Dao.MemberDao;
import mini.DaoImpl.MemberDaoImpl;
import mini.VO.Member;
import mini.service.MemberService;
import mini.util.PagingBean;
import mini.util.SqlSessionFactoryManager;

public class MemberServiceImpl implements MemberService{
	private SqlSessionFactory factory;
	private static MemberService instance;
	private MemberDao dao;
	
	// 싱글톤
	private MemberServiceImpl() throws IOException{
		factory=SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao=MemberDaoImpl.getInstance();
	}
	public static MemberService getInstance() throws IOException{
		if(instance==null){
			instance=new MemberServiceImpl();
		}
		return instance;
	}

	SqlSession sqlsession=null;
	
	List<Member> list;
	public List<Member> foundMemberBySearch(String memberName, int graduateYear, String schoolName, char memberGender) throws IOException{
		try{
			 sqlsession = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			 
			 list=dao.selectMemberByAll(sqlsession, schoolName, memberGender, graduateYear, memberName);
			 
			sqlsession.commit();

			return list;
		}finally{
			sqlsession.close();
		}
		
		
	}
	@Override
	public Map<String, Object> getMemberList(int page, String memberName, int graduateYear, String schoolName,
			char memberGender) {
		HashMap<String,Object> map=new HashMap<>();
		SqlSession slqsession = factory.openSession();
		try{
			int totalCount = dao.selectMemberCountBySerch(slqsession,schoolName, memberGender, graduateYear, memberName); // input결과의 총 (member)수가 몇 개 인지 알 수 있다.
			PagingBean pageBean=new PagingBean(totalCount,page);
			List<Member> list=dao.selectMemberListPaging(slqsession, schoolName, memberGender, graduateYear, memberName, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			
			
			map.put("pageBean", pageBean);
			map.put("list", list);
		}finally{
			sqlsession.close();
		}
		return map;
	}

	@Override
	public void insertMember(Member member) {
		SqlSession session = factory.openSession();
		try{
			dao.insertMember(session, member);
			session.commit();
		}finally {
			session.close();
		}
	}

	
	
	@Override
	public void updateMember(Member member) {
		SqlSession session = factory.openSession();
		try {
			dao.updateMember(session, member);
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Override
	public Member loginCheck(String memberId, String memberPassword) throws SQLException {
		SqlSession session = factory.openSession();
		Member member = dao.selectMemberByIdAndPwd(session, memberId, memberPassword);
		return member;
	}

	@Override
	public Member selectMemberByEmail(String memberEmail) throws SQLException {
		SqlSession session = factory.openSession();
		Member member = dao.selectMemberByEmail(session, memberEmail);
		return member;
	}

	@Override
	public Member selectMemberByIdAndEmail(String memberId, String memberEmail) throws SQLException {
		SqlSession session = factory.openSession();
		Member member = dao.selectMemberByIdAndEmail(session, memberId, memberEmail);
		return member;
	}

	@Override
	public void deleteMember(String loginId) {
		SqlSession session = factory.openSession();
		try{
			dao.deleteMember(session, loginId);
			session.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public Member selectMemberById(String memberId) throws SQLException {
		SqlSession session = factory.openSession();
		Member member = dao.selectMemberById(session, memberId);
		return member;
	}

	@Override
	public Member checkIdDuplicate(String memberId) {
		SqlSession session = factory.openSession();
		Member member = dao.checkIdDuplicate(session, memberId);
		return member;
	}

	@Override
	public Member checkEmailDuplicate(String memberEmail) {
		SqlSession session = factory.openSession();
		Member member = dao.checkEmailDuplicate(session, memberEmail);
		return member;
	}
	
}
