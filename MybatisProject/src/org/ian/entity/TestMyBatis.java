package org.ian.entity;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatis {
	public static void main(String[] args) throws IOException {
		//�[��MyBatis�t�m���(���F�X�ݼƾڮw)
		Reader reader = Resources.getResourceAsReader("conf.xml");
		//SqlSessionFactory -connection
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
		//Session�۷��jdbc�� connection
		String statement = "org.ian.entity.PersonMapper.queryPersonById";
		SqlSession session = sessionFactory.openSession();
		Person person = session.selectOne(statement,1);
		session.close();
		System.out.println(person);
	}
} 
