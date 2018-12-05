package or.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Mytestcontroller {
@RequestMapping(value="/test",method=RequestMethod.GET)
//git에 추가될 새로운 코드 예제
	public String myview() {
		return "myview";
	}
	
}
