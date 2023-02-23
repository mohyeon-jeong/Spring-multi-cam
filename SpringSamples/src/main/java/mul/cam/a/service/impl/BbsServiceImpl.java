package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.BbsDAO;
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

}
