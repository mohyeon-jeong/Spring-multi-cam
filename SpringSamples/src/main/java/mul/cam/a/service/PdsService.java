package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.PdsDTO;
import mul.cam.a.dto.PdsParam;

public interface PdsService {
	
	List<PdsDTO> pdsList(PdsParam param);
	boolean uploadPds(PdsDTO dto);
	void downcount(int seq);
	PdsDTO getPds(int seq);
	boolean updatePds(PdsDTO pds);

}
