package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.PdsDTO;

public interface PdsDAO {
	
	List<PdsDTO> pdsList();
	int uploadPds(PdsDTO dto);

}
