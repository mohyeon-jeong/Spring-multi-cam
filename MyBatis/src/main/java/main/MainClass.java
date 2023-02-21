package main;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DTO.MemberDTO;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		// read setting file
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		// Create obj of SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		// get obj of SqlSession
		SqlSession session = factory.openSession();
		
		// insert
//		MemberDTO dto = new MemberDTO("zxcv", "1234", "skin", "ad@af.ge", 3);
//		
//		int count = session.insert("addmember", dto);
//		if (count > 0) {
//			session.commit();
//			System.out.println("add success");
//		} else {
//			session.rollback();
//			System.out.println("add failed");
//		}
		
		// select (single data)
//		String id = "asdf";
//		MemberDTO dto = session.selectOne("getmember", id);
//		System.out.println(dto.toString());
//		
//		System.out.println();
		
		// select (all datas)
//		List<MemberDTO> list = session.selectList("allmember");
//		for (MemberDTO m : list) {
//			System.out.println(m.toString());
//		}
		
		// update
//		String id = "asdf";
//		MemberDTO dto = new MemberDTO("newasdf", "newasdfemail");
//		int count = session.update("updatemember", dto);
		
		// delete
		String id = "asdf";
		int count = session.delete("deletemember", id);
		if (count > 0) {
			session.commit();
			System.out.println("del success");
		} else {
			session.rollback();
			System.out.println("del failed");
		}
		
	}
	
}
