package mul.cam.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.MemberDAO;
import mul.cam.a.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	// access to mybatis
	@Autowired
	SqlSession session;

	@Override
	public List<MemberDTO> allMember() {
		return session.selectList("Member." + "allMember");
	}

}
