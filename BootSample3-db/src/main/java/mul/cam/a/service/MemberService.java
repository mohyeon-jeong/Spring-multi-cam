package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MemberDao;
import mul.cam.a.dto.MemberDTO;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	public List<MemberDTO> allMember() {
		return dao.allMember();
	}

}
