package chris.spring.web.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;
	static {
		try {
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
				//mybatis-config.xml파일로부터 정보를 읽어온다.
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}	//읽어온 정보들을 통해서 crud기능을 할 수 있는 sessionFactory를 얻어온다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
	}
	
}
