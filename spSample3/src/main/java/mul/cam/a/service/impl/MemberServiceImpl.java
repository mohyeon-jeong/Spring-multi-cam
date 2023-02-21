package mul.cam.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.cam.a.dao.MemberDAO;
import mul.cam.a.dto.MemberDTO;
import mul.cam.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	// access to DAO
	@Autowired
	MemberDAO dao;
	
	@Override
	public List<MemberDTO> allMember() {
		return dao.allMember();
	}
}
