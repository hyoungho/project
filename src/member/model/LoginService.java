package member.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	@Autowired
	SqlSessionFactory fac;

	public int check(String id, String pass) {
		SqlSession sql = fac.openSession();
		HashMap<String, String> map = new HashMap<>();
			map.put("id", id);
			map.put("pass", pass);
		List<HashMap> rst = sql.selectList("member.find", map);

		return rst.size();
	}
	
}

