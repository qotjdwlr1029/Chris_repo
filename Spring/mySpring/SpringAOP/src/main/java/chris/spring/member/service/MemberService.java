package chris.spring.member.service;

import chris.spring.member.vo.MemberVO;
import chris.spring.member.vo.UpdateInfo;

public interface MemberService {
	
	void regist(MemberVO member);
	boolean update(String memberId, UpdateInfo info);
	
}
