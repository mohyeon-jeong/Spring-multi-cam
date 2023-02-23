package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;

public interface BbsDAO {
	
	List<BbsDTO> bbsList(BbsParam bbs);
	int getAllBbs(BbsParam bbs);
	int writeBbs(BbsDTO dto);
	BbsDTO getBbs(int seq);

}
