package or.kosta.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.kosta.mvc.dao.ShowDao;
import or.kosta.vo.PageVO;
import or.kosta.vo.SearchVO;
import or.kosta.vo.ShowVO;


@Controller
public class SearchController {
	@Autowired
	private ShowDao dao;

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView listSearch(int page,String searchType, String searchValue){
		System.out.println("SearchType :"+searchType);
		System.out.println("SearchValue :"+searchValue);
		//------------------------------
        PageVO pageInfo = new PageVO();

		int rowsPerPage = 5;

		int pagesPerBlock = 5;

		int currentPage = 1;
	
		int currentBlock = 0;

		if(currentPage % pagesPerBlock == 0){
			currentBlock = currentPage / pagesPerBlock;
		}else{
			currentBlock = currentPage / pagesPerBlock + 1;
		}

		int startRow = (currentPage - 1) * rowsPerPage + 1;
		int endRow = currentPage * rowsPerPage;
		// MyBatis�� �����ϱ� ���ؼ� �������� ���۰��� ���������� �����Ѵ�.
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("begin", startRow);
//		map.put("end", endRow);
//		map.put("searchType", searchType);
//		map.put("searchValue", searchValue);
		SearchVO svo = new SearchVO();
		svo.setBegin(String.valueOf(startRow));
		svo.setEnd(String.valueOf(endRow));
		svo.setSearchType(searchType);
		svo.setSearchValue(searchValue);
		
		// ��ü ���ڵ� �� 
		int totalRows = dao.getTotalCount(svo);
		System.out.println("totalRows:"+totalRows);
		int totalPages = 0;
		//��ü �������� ���ϴ� ����
		if(totalRows % rowsPerPage == 0){
			totalPages = totalRows / rowsPerPage;
		}else{
			totalPages = totalRows / rowsPerPage + 1;
		}

		// ��ü ����� ���ϴ� ����
		int totalBlocks = 0;
		if(totalPages % pagesPerBlock == 0){
			totalBlocks = totalPages / pagesPerBlock;
		}else{
			totalBlocks = totalPages / pagesPerBlock + 1;
		}
		// PageVO�� setter�� ���� ����.
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setCurrentBlock(currentBlock);
		pageInfo.setRowsPerPage(rowsPerPage);
		pageInfo.setPagesPerBlock(pagesPerBlock);
		pageInfo.setStartRow(startRow);
		pageInfo.setEndRow(endRow);
		pageInfo.setTotalRows(totalRows);
		pageInfo.setTotalPages(totalPages);
		pageInfo.setTotalBlocks(totalBlocks);
	
		//-------------------------------
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showlist");
		//Map�� Dao�� ����.
		List<ShowVO> list = dao.getListSearch(svo);
		// �������� ����Ʈ ���� ModelAndView�� ����ؼ� �� ����.
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("searchType", searchType);
		mav.addObject("searchValue", searchValue);
		mav.addObject("list", list);
		return mav;
	}
	
}
