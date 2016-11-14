package file.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadService {
	@Autowired
	SqlSessionFactory fac;
	
	public List getTop3() {
		SqlSession session = fac.openSession();
		List<FileData>  list = session.selectList("file.readTop3");
		session.close();
		return list;
	}
	
	public FileData getOne(int num) {
		SqlSession session = fac.openSession();
		int r = session.update("file.upCount", num);
		if(r==0)
			return null;
		
		FileData fd = session.selectOne("file.readOne", num);
		session.close();
		return fd;
	}
	
	
	
	public List<FileData> getAllDefault() {
		SqlSession session = fac.openSession();
		List<FileData>  list = session.selectList("file.readAll");
		session.close();
		return list;
	}
	
}
