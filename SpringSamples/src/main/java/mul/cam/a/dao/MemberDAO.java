package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.MemberDTO;

public interface MemberDAO {

	List<MemberDTO> allMember();
	String idCheck(String a);
	int addMember(MemberDTO dto);
	MemberDTO login(MemberDTO dto);
	
}
