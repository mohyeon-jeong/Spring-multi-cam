package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.MemberDTO;

public interface MemberService {

	List<MemberDTO> allMember();
	String idCheck(String a);
	boolean addMember(MemberDTO dto);
	MemberDTO login(MemberDTO dto);
	
}
