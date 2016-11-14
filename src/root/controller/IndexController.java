package root.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String welcome() {
		String viewName = null;
		return "t:index";
	}
	@RequestMapping("/user/join.do")
	public String moveJoinView() {
		return "t:join";
	}
}
