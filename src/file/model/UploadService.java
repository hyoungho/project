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
	// �������� ���.
	// 1. �ߺ����ϸ��� ��� ó��?- UUID �� Ŭ������ ����� �غ���
	// 2. ����ڵ��� ���ε��Ų ���ϵ��� Ư�� ��ο��ٰ� ������ �ؾߵǴ°�? 
 		// �ذ����.. ������Ʈ���� ������ getRealPath() �� �̿��ؼ�.
	
	// Spring ������ ���ư��� �ڵ����� ����� �Ǵ� ����. 
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
	
	// ���� �ϵ忡 ������ �ϴ°�
	public String execute(MultipartFile f) {
		if(f.isEmpty()) {
			return null;
		}
		try {
			String uid = UUID.randomUUID().toString();
			System.out.println(uid.substring(0,23));
			// Application ��ü�� ������.. WAS �� ��ġ�� ���� ��������
			// �� ������ �����Ҽ� ������ ������.. ��� Ȯ��..
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
		// ���� �ִ� ����.
		try {
			boolean b= f.isEmpty();	// -- �ڡ�
			InputStream is = f.getInputStream();	// �ӽ����Ͽ��� inputStream�� ������ ����
			String ct = f.getContentType();	// ?��
			String fileName = f.getOriginalFilename();	// -- �ڡ�
			String name = f.getName();	// ���Ͽ� ������ �Ķ���� �� vs getOriginalFileName ? 
			long size = f.getSize();	// ����ũ�� byte ��
			// size/1024 
			// ���� ���丮 ��ü�� �־�� ��.!
			File dest = new File("d:/pmPool", fileName);
			f.transferTo(dest);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}




