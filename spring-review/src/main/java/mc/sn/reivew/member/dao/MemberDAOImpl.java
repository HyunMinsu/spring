package mc.sn.reivew.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mc.sn.reivew.member.vo.MemberVO;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

//	@Override
//	public List selectAllMemberList() throws DataAccessException {
//		List<MemberVO> membersList = null;
//		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
//		return membersList;
//	}
//
//	@Override
//	public int insertMember(MemberVO memberVO) throws DataAccessException {
//		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
//		return result;
//	}
//
//	@Override
//	public int deleteMember(String id) throws DataAccessException {
//		int result = sqlSession.delete("mapper.member.deleteMember", id);
//		return result;
//	}
//	
	@Override
	public MemberVO loginById(MemberVO memberVO) throws Exception{
		  MemberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
		 System.out.println("dao in");
		 return vo;
	}

}
