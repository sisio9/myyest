package or.kosta.mvc.service;

import or.kosta.vo.CustomerVO;
import or.kosta.vo.MemberVO;
public interface ServiceInter {
	// transaction�� ó�� �ϱ� ���� �߻�޼���
	public void addAll(MemberVO mvo,CustomerVO cvo) throws Exception;
}