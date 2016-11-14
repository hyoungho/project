package review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import review.model.ReviewReadService;

@Controller
public class ReivewController {
	@Autowired
	ReviewReadService rrServ;
	
	@RequestMapping("/review/list.do")
	public ModelAndView listResolve(
			@RequestParam(defaultValue="1") int p) {
		List loi =rrServ.readRange(p);
		int size = rrServ.getPageSize();
		ModelAndView mav = new ModelAndView();
			mav.addObject("data", loi);
			mav.addObject("size", size );
			mav.addObject("current", p );
			mav.setViewName("t:reviewall");
		return mav;
	}
	
	
}









