package review.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewReadService {
	@Autowired
	SqlSessionFactory fac;
	
	public List readRange(int p) {
		SqlSession sql = fac.openSession();
		HashMap map = new HashMap();
			map.put("start", (p-1)*5 + 1 );
			map.put("end", p*5);
		List m = sql.selectList("review.readRange", map);
		sql.close();
		return m;
	}
	public int getPageSize() {
		SqlSession sql = fac.openSession();
		int tot = sql.selectOne("review.totalCount");
		sql.close();
		return tot%5==0? tot/5 : tot/5+1;
		
	}
}






















