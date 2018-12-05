package or.kosta.mvc.service;

import or.kosta.vo.CustomerVO;
import or.kosta.vo.MemberVO;
public interface ServiceInter {
	// transaction을 처리 하기 위한 추상메서드
	public void addAll(MemberVO mvo,CustomerVO cvo) throws Exception;
}
