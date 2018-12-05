package or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.kosta.vo.MemberVO;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate ss;
	public void addMember(MemberVO vo){
		ss.insert("mem.addMember", vo);
	}
}
