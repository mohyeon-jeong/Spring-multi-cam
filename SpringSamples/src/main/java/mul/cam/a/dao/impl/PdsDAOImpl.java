package mul.cam.a.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.PdsDAO;
import mul.cam.a.dto.PdsDTO;
import mul.cam.a.dto.PdsParam;

@Repository
public class PdsDAOImpl implements PdsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Pds.";
	
	@Override
	public List<PdsDTO> pdsList(PdsParam param) {
		return session.selectList(ns + "pdsList", param);
	}
	
	@Override
	public int uploadPds(PdsDTO dto) {
		return session.insert(ns + "uploadPds", dto);
	}
	
	@Override
	public void downcount(int seq) {
		session.update(ns + "downcount", seq);
	}
	
	@Override
	public PdsDTO getPds(int seq) {
		return session.selectOne(ns + "getPds", seq);
	}
	
	@Override
	public int updatePds(PdsDTO pds) {
		return session.update(ns + "updatePds", pds);
	}

}
