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
// 기존의 트랜잭션이 존재한다면 그 트랜잭션을 지원하고, 
// 기존의 트랜잭션이 없다면 새로운 트랜잭션을 시작한다'는 의미,
//(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
//noRollbackFor=Exception.class 해당 예외가 발생했을 때는 rollback을 하지 않겠다.
//rollbackFor = Exception.class 해당 예외만 발생 했을 때 rollback을 수행함!

// ex) noRollbackFor=DuplicateKeyException.class 일땐 롤백안됨
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
		memberDao.addMember(mvo); // 정상일경우 commit
		customerDao.addCustomer(cvo); 
		// 비정상이니까 데이터가 commit이 못됨
		// 문제는 단위처리가 되어야 하는데 .. 
		// member_tx만 들어가 가는 현상이 발생
		// - 트랜잭션이 필요!
	}
}








