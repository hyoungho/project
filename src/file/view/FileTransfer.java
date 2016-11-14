package file.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import file.model.FileData;

@Component
public class FileTransfer extends AbstractView {
	@Autowired
	ServletContext sc;
	
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 컨트롤러에서 넘어오는 뷰인데..
		FileData fd = (FileData)model.get("file");
		System.out.println(fd.getFileuuid());
		System.out.println(fd.getFilename());
		String name = fd.getFilename();
		String kname =new String(name.getBytes("utf-8"),"iso-8859-1");
		response.setHeader("Content-Disposition", "attachment;filename=\"" +kname + "\"");
		OutputStream out = response.getOutputStream();
		InputStream in =new FileInputStream(new File(sc.getRealPath("/files") , fd.getFileuuid()));
		
		FileCopyUtils.copy(in, out);
		
		/*
		while(true) {
			int b = in.read();
			if(b == -1)
				break;
			out.write(b);
		}
		*/
		
	}
	

}




