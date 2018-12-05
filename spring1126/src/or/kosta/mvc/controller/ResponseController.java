package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/respTest")
public class ResponseController {
	
	@GetMapping("/resptest")
	@ResponseBody
	public String message() {
		return "hello";
	}
	
}
