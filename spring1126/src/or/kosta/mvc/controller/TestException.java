package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestException {
	// testEx�� ���� ��û�� ���� �� arrayException.jsp�� ����� �ǵ��� 
	// ���ܸ� �����ϰ� , ������ ���ܴ� exception���� ó�� �Ͻÿ�.
	@RequestMapping(value="testEx")
	public ModelAndView testview(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		String[] ar = {"a","b","c"};
		for(int i=0; i<=ar.length; i++){
			System.out.println(ar[i]);
		}
		return mav;
	}
}
