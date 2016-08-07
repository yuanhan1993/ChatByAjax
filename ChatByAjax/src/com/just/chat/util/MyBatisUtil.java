package com.just.chat.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
 public static SqlSession getSqlSession(){
	 SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
			//����SqlMapConfig.xml�ļ�
			String conf = "SqlMapConfig.xml";
			InputStream confStream = 
				MyBatisUtil.class.getClassLoader()
			   .getResourceAsStream(conf);
			//��ȡSqlSessionFactory
			SqlSessionFactory factory = 
					builder.build(confStream);
			//��ȡSqlSession
			SqlSession session = 
					factory.openSession();
			return session;
 }
}
