package or.kosta.excel;

import java.awt.Font;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import or.kosta.vo.ShowVO;

@SuppressWarnings("deprecation")
public class ExcelBuilder extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// HSSF - 마이크로 소프트의 엑셀전용 클래스
		// DispatcherServlet에 의해서 Model을 받습니다.
		// ${listBooks}
		List<ShowVO> list = (List<ShowVO>) model.get("list");

		// poi문법
		HSSFSheet sheet = workbook.createSheet("Show Lists");
		sheet.setDefaultColumnWidth(30);
		CellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		HSSFRow header = sheet.createRow(0);

		// 엑셀의 셀 타이틀
		String[] str = { "번호", "코드", "이미지", "작성자", "가격", "날짜" };
		for (int i = 0; i < str.length; i++) {
			header.createCell(i).setCellValue(str[i]);
			header.getCell(i).setCellStyle(style);
		}

		int rowCount = 1;
		// 셀의 내용을 채움
		for (ShowVO vo : list) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(vo.getNum());
			aRow.createCell(1).setCellValue(vo.getGrpcode());
			aRow.createCell(2).setCellValue(vo.getPath());
			aRow.createCell(3).setCellValue(vo.getWriter());
			aRow.createCell(4).setCellValue(vo.getPrice());
			aRow.createCell(5).setCellValue(vo.getRegdate());
		}
		// 응답 객체로부터 다운로드 받을 타입과 파일이름을 설정한다.
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "attachment; filename=board_excel.xls");
	}

}
