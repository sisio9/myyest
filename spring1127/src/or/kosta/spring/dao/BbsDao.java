package or.kosta.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.Bbs1CommVO;
import vo.Bbs1VO;
import vo.SearchVO;

@Repository
public class BbsDao {
	@Autowired
	private SqlSessionTemplate ss;

	public void insertBbs1(Bbs1VO vo) {
		ss.insert("bbs1.ins", vo);
	}

	public List<Bbs1VO> getList(SearchVO vo) {
		return ss.selectList("bbs1.list", vo);
	}

	public int getTotalCount() {
		return ss.selectOne("bbs1.listTotal");
	}

	public Bbs1VO getDetail(int num) {
		return ss.selectOne("bbs1.detail", num);
	}

	// comm
	public void insertComm(Bbs1CommVO vo) {
		ss.insert("bbs1.commIn", vo);
	}

	public List<Bbs1CommVO> getCommList(int kcode) {
		return ss.selectList("bbs1.commList", kcode);
	}

	public void BbsHitUp(int num) {
		ss.update("bbs1.hitup", num);
	}

}
