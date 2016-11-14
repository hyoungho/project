package member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.model.JoinData;
import member.model.JoinService;

@Controller
public class JoinController {
	@Autowired
	JoinService joinService;
		
	@RequestMapping("/member/check.do")
	@ResponseBody
	public String checkProceed(String id) {
		boolean rst = joinService.possible(id);
		if(rst) 
			return "YES";
		else
			return "NO";
	}
	
	
	
	@RequestMapping("/member/confirm.do")
	public ModelAndView joinProceed(String id, String pass, String name){
		ModelAndView mav = new ModelAndView();
		boolean rst = joinService.register(id, pass, name);
		System.out.println("RST=="+rst);
		return null;
	}
	
//	@RequestMapping("/member/confirm.do")
	public ModelAndView joinProceed2(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		HashMap map = new HashMap();
		map.put("id", req.getParameter("id"));
		map.put("pass", req.getParameter("pass"));
		map.put("name", req.getParameter("name"));
		boolean rst = joinService.register(map);
		System.out.println("RST=="+rst);
		return null;
	}
	
	
//	@RequestMapping("/member/confirm.do")
	public ModelAndView joinProceed3(JoinData mem){
		ModelAndView mav = new ModelAndView();
		boolean rst = joinService.register(mem);
		System.out.println("RST=="+rst);
		return null;
	}
}




