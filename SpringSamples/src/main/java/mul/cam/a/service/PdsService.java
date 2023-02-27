package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.PdsDTO;

public interface PdsService {
	
	List<PdsDTO> pdsList();
	boolean uploadPds(PdsDTO dto);

}
