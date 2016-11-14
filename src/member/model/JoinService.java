package member.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 컨틀롤러에서 필요한 작업들을 가지고 있는 클래스 
@Component
public class JoinService {
	@Autowired
	SqlSessionFactory factory;

	public boolean possible(String tid) {
		SqlSession sql = factory.openSession();
		List r = sql.selectList("member.searchId", tid);
		sql.close();
		if (r.size() == 0)
			return true;
		else
			return false;
	}

	public boolean register(String id, String pass, String name) {
		SqlSession sql = factory.openSession();
		HashMap param = new HashMap();
		param.put("id", id);
		param.put("pass", pass);
		param.put("name", name);
		int r = sql.insert("member.insertMap", param);
		if (r > 0)
			return true;
		else
			return false;
	}

	public boolean register(HashMap param) {
		SqlSession sql = factory.openSession();
		int r = sql.insert("member.insertMap", param);
		if (r > 0)
			return true;
		else
			return false;
	}

	public boolean register(JoinData param) {
		SqlSession sql = factory.openSession();
		int r = sql.insert("member.insertPojo", param);

		if (r > 0)
			return true;
		else
			return false;
	}
}
