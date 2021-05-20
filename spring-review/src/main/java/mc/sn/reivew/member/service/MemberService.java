package mc.sn.reivew.member.service;

import mc.sn.reivew.member.vo.MemberVO;


public interface MemberService {
	 //public List listMembers() throws DataAccessException;
	 //public int addMember(MemberVO memberVO) throws DataAccessException;
	//public int removeMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
}
