package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.BbsComment;
import mul.cam.a.dto.BbsDTO;
import mul.cam.a.dto.BbsParam;

public interface BbsDAO {
	
	List<BbsDTO> bbsList(BbsParam bbs);
	int getAllBbs(BbsParam bbs);
	int writeBbs(BbsDTO dto);
	BbsDTO getBbs(int seq);
	int updateBbs(BbsDTO dto);
	int deleteBbs(int seq);
	void updateStep(int seq);
	int writeAnswer(BbsDTO dto);
	
	// comment
	int commentWrite(BbsComment bbs);
	List<BbsComment> commentList(int seq);

}
