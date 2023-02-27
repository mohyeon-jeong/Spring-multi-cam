package mul.cam.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.PdsDAO;
import mul.cam.a.dto.PdsDTO;

@Repository
public class PdsDAOImpl implements PdsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Pds.";
	
	@Override
	public List<PdsDTO> pdsList() {
		return session.selectList(ns + "pdsList");
	}
	
	@Override
	public int uploadPds(PdsDTO dto) {
		return session.insert(ns + "uploadPds", dto);
	}

}
