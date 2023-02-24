package mul.cam.a.service;

import java.util.List;

import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;

public interface BbsService {
	
	List<BbsDTO> bbsList(BbsParam bbs);
	int getAllBbs(BbsParam bbs);
	boolean writeBbs(BbsDTO dto);
	BbsDTO getBbs(int seq);
	boolean updateBbs(BbsDTO dto);
	boolean deleteBbs(int seq);
	boolean writeAnswer(int seq, BbsDTO dto);
	
	// comment
	boolean commentWrite(BbsComment bbs);
	List<BbsComment> commentList(int seq);

}
