package file.model;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadService {
	// 최종개선 방안.
	// 1. 중복파일명을 어떻게 처리?- UUID 란 클래스를 사용을 해보자
	// 2. 사용자들이 업로드시킨 파일들을 특정 경로에다가 지정을 해야되는가? 
 		// 해결법은.. 프로젝트내에 저장을 getRealPath() 를 이용해서.
	
	// Spring 설정이 돌아갈때 자동으로 등록이 되는 빈임. 
	@Autowired
	ServletContext application;
	@Autowired
	SqlSessionFactory fac;
	
	
	public int register(String uid, MultipartFile file, String title, String ctg, String uploader) {
		HashMap<String , Object> map = new HashMap<>();
		long size = file.getSize();
		String name = file.getOriginalFilename();
		
		map.put("ctg", ctg);
		map.put("title", title);
		map.put("filename", name);
		map.put("uploader", uploader);
		map.put("fileuuid", uid);
		map.put("filesize", size);
		try {
			SqlSession sql = fac.openSession();
			int rst = sql.insert("file.upload",map);
			sql.close();
			return rst;
		}catch(Exception e) {
			return -1;
		}
	}
	
	// 서버 하드에 저장을 하는것
	public String execute(MultipartFile f) {
		if(f.isEmpty()) {
			return null;
		}
		try {
			String uid = UUID.randomUUID().toString();
			System.out.println(uid.substring(0,23));
			// Application 객체만 있으면.. WAS 의 위치를 얻어내서 그쪽으로
			// 잘 파일을 저장할수 있을꺼 같은데.. 어떻게 확보..
			String fileDir = application.getRealPath("/files");
//			String fileDir = application.getRealPath("/WEB-INF/files");
			String fileName = uid.substring(0,23);
			File dest = new File(fileDir, fileName);
			System.out.println(fileDir);
			f.transferTo(dest);
			return fileName;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean executeInfo(MultipartFile f) {
		// 얻어낼수 있는 정보.
		try {
			boolean b= f.isEmpty();	// -- ★★
			InputStream is = f.getInputStream();	// 임시파일에서 inputStream을 얻을수 있음
			String ct = f.getContentType();	// ?★
			String fileName = f.getOriginalFilename();	// -- ★★
			String name = f.getName();	// 파일에 설정된 파라미터 명 vs getOriginalFileName ? 
			long size = f.getSize();	// 파일크기 byte ★
			// size/1024 
			// 저장 디렉토리 자체는 있어야 함.!
			File dest = new File("d:/pmPool", fileName);
			f.transferTo(dest);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}




