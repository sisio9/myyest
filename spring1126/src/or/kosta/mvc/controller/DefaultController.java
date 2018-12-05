package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	@RequestMapping("/")
	public String defaultView(){
		return "index";
	}

	@RequestMapping(value="/myindex")
	public String myDefaultView(){
		return "index";
	}
	@RequestMapping(value="/mytest")
	public String myDefaultView1(){
		return "index";
	}
}
