package mc.sn.reivew.member.dao;

//import org.springframework.dao.DataAccessException;

import mc.sn.reivew.member.vo.MemberVO;

public interface MemberDAO {
//	 public List selectAllMemberList() throws DataAccessException;
//	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
//	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO loginById(MemberVO memberVO) throws Exception;

}
