package file.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileSearchService {
	@Autowired
	SqlSessionFactory fac;
	
	public List findStartWith(String word){
		SqlSession sql = fac.openSession();
			List li =sql.selectList("file.searchSome", word+"%");
		sql.close();
		return li;
	}
	
	public List findContains(String word){
		SqlSession sql = fac.openSession();
			List li =sql.selectList("file.searchSome", "%"+word+"%");
		sql.close();
		return li;
	}
	
	public List findEndWith(String word){
		SqlSession sql = fac.openSession();
			List li =sql.selectList("file.searchSome", "%" +word);
		sql.close();
		return li;
	}
	
	
}








