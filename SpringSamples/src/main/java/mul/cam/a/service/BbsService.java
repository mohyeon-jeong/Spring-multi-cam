package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;

public interface BbsService {
	
	List<BbsDTO> bbsList(BbsParam bbs);
	int getAllBbs(BbsParam bbs);
	boolean writeBbs(BbsDTO dto);
	BbsDTO getBbs(int seq);

}
