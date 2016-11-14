package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.model.LoginService;
import socket.controller.ReceiveController;

@Controller
public class LoginController {
	@Autowired
	ReceiveController rc;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/member/loginAuth.do")
	public ModelAndView proceed(HttpSession session, String id, String pass){
		ModelAndView mav = new ModelAndView();
		int rst = loginService.check(id, pass);
		if(rst ==1) {
			session.setAttribute("userId", id);
			mav.setViewName("redirect:/index.do");
			rc.sendMessage("누군가 로그인");
		}else {
			mav.setViewName("member/loginFail");
		}
		return mav;
	}
}
