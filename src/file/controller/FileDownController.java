package file.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import file.model.FileData;
import file.model.ReadService;

@Controller
public class FileDownController {
	@Autowired
	ReadService readSvr;
	@Autowired
	ServletContext application;
	
	@RequestMapping("/file/down.do")
	public ModelAndView resolve(int num) {
		ModelAndView mav = new ModelAndView();
		FileData fd = readSvr.getOne(num);
		if(fd == null)
			mav.setViewName("file/error");
		else {
			if(new File(application.getRealPath("/files"), fd.getFileuuid()).exists()) {
				mav.setViewName("fileTransfer");
				mav.addObject("file", fd);
			}else {
				mav.setViewName("file/error");
			}
		}
		return mav;
	}
}



