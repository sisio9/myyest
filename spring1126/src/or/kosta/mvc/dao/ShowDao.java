package or.kosta.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.kosta.vo.SearchVO;
import or.kosta.vo.ShowVO;

@Repository
public class ShowDao {
	@Autowired
	private SqlSessionTemplate ss;
	public void saveShow(ShowVO vo){
		System.out.println("Writer:"+vo.getWriter());
		System.out.println("Grpcode:"+vo.getGrpcode());
		System.out.println("Price:"+vo.getPrice());
		System.out.println("Path:"+vo.getPath());
		System.out.println("Pwd:"+vo.getPwd());
		System.out.println("Comm:"+vo.getComm());
		System.out.println("Reip:"+vo.getReip());
		ss.insert("showshop.showins", vo);
	}
	public List<ShowVO> getList(SearchVO svo){
		return ss.selectList("showshop.list", svo);
	}
	
	
	public List<ShowVO> getListSearch(SearchVO svo){
		System.out.println("MAp"+svo.getSearchValue());
		return ss.selectList("showshop.listsearch", svo);
	}
	
	public int getTotalCount(SearchVO svo){
		return ss.selectOne("showshop.totalCount",svo);
	}
	public List<ShowVO> listBooks(){
		return ss.selectList("showshop.listAll");
	}
}
