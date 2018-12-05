package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestException {
	// testEx에 대한 요청이 왔을 때 arrayException.jsp가 출력이 되도록 
	// 예외를 설정하고 , 나머지 예외는 exception으로 처리 하시오.
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
