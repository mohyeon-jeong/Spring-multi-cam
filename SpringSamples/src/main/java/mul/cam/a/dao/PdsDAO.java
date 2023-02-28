package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.PdsDTO;
import mul.cam.a.dto.PdsParam;

public interface PdsDAO {
	
	List<PdsDTO> pdsList(PdsParam param);
	int uploadPds(PdsDTO dto);
	void downcount(int seq);
	PdsDTO getPds(int seq);
	int updatePds(PdsDTO pds);

}
