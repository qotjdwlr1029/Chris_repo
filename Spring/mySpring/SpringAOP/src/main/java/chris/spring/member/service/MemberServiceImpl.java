package chris.spring.member.service;

import chris.spring.member.vo.MemberVO;
import chris.spring.member.vo.UpdateInfo;

public class MemberServiceImpl implements MemberService {

	//MemberDAO 주입(DI)
	@Override
	public void regist(MemberVO member) {
		System.out.println("MemberServiceImpl.regist()메서드 실행");
	}

	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update()메서드 실행");
		return true;
	}

}
