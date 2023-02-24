package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.BbsDAO;
import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;
import mul.cam.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDAO dao;
	
	@Override
	public List<BbsDTO> bbsList(BbsParam bbs) {
		return dao.bbsList(bbs);
	}
	
	@Override
	public int getAllBbs(BbsParam bbs) {
		return dao.getAllBbs(bbs);
	}
	
	@Override
	public boolean writeBbs(BbsDTO dto) {
		int count = dao.writeBbs(dto);
		return count > 0 ? true : false;
	}
	
	@Override
	public BbsDTO getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	@Override
	public boolean updateBbs(BbsDTO dto) {
		int count = dao.updateBbs(dto);
		return count > 0 ? true : false;
	}
	
	@Override
	public boolean deleteBbs(int seq) {
		int count = dao.deleteBbs(seq);
		return count > 0 ? true : false;
	}
	
	@Override
	public boolean writeAnswer(int seq, BbsDTO dto) {
		dao.updateStep(seq);
		int count = dao.writeAnswer(dto);
		return count > 0 ? true : false;
	}
	
	@Override
	public boolean commentWrite(BbsComment bbs) {
		int n = dao.commentWrite(bbs);
		return n > 0 ? true : false;
	}
	
	@Override
	public List<BbsComment> commentList(int seq) {
		return dao.commentList(seq);
	}

}
