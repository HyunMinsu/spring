package mc.sn.reivew.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mc.sn.reivew.member.dao.MemberDAO;
import mc.sn.reivew.member.vo.MemberVO;



@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

//	@Override
//	public List listMembers() throws DataAccessException {
//		List membersList = null;
//		//membersList = memberDAO.selectAllMemberList();
//		return membersList;
//	}

	
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		MemberVO vo = null;
		vo = memberDAO.loginById(memberVO);
		System.out.println("service in");
		return vo;
	}

}
