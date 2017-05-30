package mini.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	private SqlSessionFactory factory;
	private static SqlSessionFactoryManager instance;
	public static SqlSessionFactoryManager getInstance() throws IOException{
		if(instance==null){
			instance=new SqlSessionFactoryManager();
		}
		return instance;
	}
	
	private SqlSessionFactoryManager() throws IOException{
		InputStream in = Resources.getResourceAsStream("mini/config/mybatis-config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory=builder.build(in); // 전역 설정 파일의 inputStream으로 넣어서 SqlSessionFactory생성
		
// 		한번에 처리하는 문장.
//		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("hr/dao/config/mybatis-config.xml"));
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
}
