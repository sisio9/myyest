package or.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Workcontroller {
	@RequestMapping("/test")
public String test() {
	return "test";
}
}
