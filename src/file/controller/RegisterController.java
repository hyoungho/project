package file.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import file.model.UploadService;
import socket.controller.AlertHandler;

@Controller
public class RegisterController {
	@Autowired
	UploadService upSrv;
	
	@Autowired
	AlertHandler ahandler;
	
	@RequestMapping(value="/file/reg.do" )
	public String proceed() {
		return "t:file";
	}
	
	@RequestMapping("/file/upload.do")
	public String proceed2(HttpSession session, String title, String ctg, @RequestParam(name="file") MultipartFile file) {
		System.out.println(title+"/"+ctg+"/"+file);
		String uid = upSrv.execute(file);
		if(uid != null) {
			String uploader = (String)session.getAttribute("userId");
			int r = upSrv.register(uid, file, title, ctg, uploader);
			if(r==1) {
				ahandler.sendMessageToAll("XXX");
				
				return "redirect:/file/list.do";
			}
		}
		return "file/fail";
	}
}

/*
	Spring ��ü�� multipart/form-data ������ ��û�� ó���Ҽ� ����.
	������, ������ �Ѵ�. (multipart ������ ��û�� ó���Ҽ� �ִ� ���̺귯�� ��)
	
	�� commons file upload library   (maven���� �̰� �����ð�)
	
	�� spring bean config ���� 
	
	



*/






