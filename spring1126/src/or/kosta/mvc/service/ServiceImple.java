package or.kosta.mvc.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import or.kosta.mvc.dao.CustomerDao;
import or.kosta.mvc.dao.MemberDao;
import or.kosta.vo.CustomerVO;
import or.kosta.vo.MemberVO;
// propagation=Propagation.REQUIRED
// ������ Ʈ������� �����Ѵٸ� �� Ʈ������� �����ϰ�, 
// ������ Ʈ������� ���ٸ� ���ο� Ʈ������� �����Ѵ�'�� �ǹ�,
//(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
//noRollbackFor=Exception.class �ش� ���ܰ� �߻����� ���� rollback�� ���� �ʰڴ�.
//rollbackFor = Exception.class �ش� ���ܸ� �߻� ���� �� rollback�� ������!

// ex) noRollbackFor=DuplicateKeyException.class �϶� �ѹ�ȵ�
@Transactional(propagation=Propagation.REQUIRED,
rollbackFor=Exception.class,readOnly = true)
@Service
public class ServiceImple implements ServiceInter{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private CustomerDao customerDao;
	@Override
	public void addAll(MemberVO mvo, CustomerVO cvo) throws Exception {
		memberDao.addMember(mvo); // �����ϰ�� commit
		customerDao.addCustomer(cvo); 
		// �������̴ϱ� �����Ͱ� commit�� ����
		// ������ ����ó���� �Ǿ�� �ϴµ� .. 
		// member_tx�� �� ���� ������ �߻�
		// - Ʈ������� �ʿ�!
	}
}








