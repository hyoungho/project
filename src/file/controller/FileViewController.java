package file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import file.model.ReadService;

@Controller
public class FileViewController {
	@Autowired
	ReadService readSrv;
	
	@RequestMapping("/file/list.do")
	public ModelAndView allview() {
		ModelAndView mav = new ModelAndView();
			List li = readSrv.getAllDefault();
			mav.addObject("list", li);
			mav.addObject("size", li.size());
			mav.setViewName("t:filelist");
			mav.addObject("tlist", readSrv.getTop3());
		return mav;
	}
	
	
}
