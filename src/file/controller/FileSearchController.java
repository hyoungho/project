package file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import file.model.FileSearchService;

@Controller
public class FileSearchController {
	@Autowired
	FileSearchService fsServ;
	
	
	@RequestMapping("/file/searchJSON.do")
	@ResponseBody
	public List searchResolve(String q) {
		List li = fsServ.findStartWith(q);
		// ResopnseBody ��ü�� ������ ��ų���� �ִ�.
		// ��, ���̺귯���� �ʿ�. jackson bind
		return li;
	}
	
	@RequestMapping("/file/searchXML.do")
	public ModelAndView searchResolveType2(String q) {
		List li = fsServ.findStartWith(q);
		// ResopnseBody ��ü�� ������ ��ų���� �ִ�.
		// ��, ���̺귯���� �ʿ�. jackson bind
		ModelAndView mav = new ModelAndView();
			mav.addObject("li", li);
			mav.setViewName("file/searchResult");
		return mav;
	}
}









