package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.PdsDAO;
import mul.cam.a.dto.PdsDTO;
import mul.cam.a.dto.PdsParam;
import mul.cam.a.service.PdsService;

@Service
public class PdsServiceImpl implements PdsService {

	@Autowired
	PdsDAO dao;

	@Override
	public List<PdsDTO> pdsList(PdsParam param) {
		return dao.pdsList(param);
	}

	@Override
	public boolean uploadPds(PdsDTO dto) {
		int a = dao.uploadPds(dto);
		return a > 0 ? true : false;
	}
	
	@Override
	public void downcount(int seq) {
		dao.downcount(seq);
	}

	@Override
	public PdsDTO getPds(int seq) {		
		return dao.getPds(seq);
	}

	@Override
	public boolean updatePds(PdsDTO pds) {		
		int n = dao.updatePds(pds);
		return n > 0 ? true : false;
	}	

}
