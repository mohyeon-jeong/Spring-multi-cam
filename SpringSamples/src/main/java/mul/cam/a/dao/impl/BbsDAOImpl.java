package mul.cam.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.cam.a.dao.BbsDAO;
import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;

@Repository
public class BbsDAOImpl implements BbsDAO {
	
	@Autowired
	SqlSession session;
	
	String ns = "BBS.";
	
	@Override
	public List<BbsDTO> bbsList(BbsParam bbs) {
		return session.selectList(ns + "bbsList", bbs);
	}
	
	@Override
	public int getAllBbs(BbsParam bbs) {
		return session.selectOne(ns + "getAllBbs", bbs);
	}
	
	@Override
	public int writeBbs(BbsDTO dto) {
		int count = session.insert(ns + "writeBbs", dto);
		return count;
	}
	
	@Override
	public BbsDTO getBbs(int seq) {
		return session.selectOne(ns + "getBbs", seq);
	}
	
	@Override
	public int updateBbs(BbsDTO dto) {
		return session.update(ns + "updateBbs", dto);
	}
	
	@Override
	public int deleteBbs(int seq) {
		return session.update(ns + "deleteBbs", seq);
	}
	
	@Override
	public void updateStep(int seq) {
		session.update(ns + "updateStep", seq);
	}
	
	@Override
	public int writeAnswer(BbsDTO dto) {
		return session.insert(ns + "writeAnswer", dto);
	}
	
	@Override
	public int commentWrite(BbsComment bbs) {
		return session.insert(ns + "commentWrite", bbs);
	}
	
	@Override
	public List<BbsComment> commentList(int seq) {
		return session.selectList(ns + "commentList", seq);
	}

}
