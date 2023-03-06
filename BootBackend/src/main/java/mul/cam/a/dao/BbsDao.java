package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {

	List<BbsDto> bbslist(BbsParam param);	
	int getAllBbs(BbsParam param);
	
	BbsDto getBbs(int seq);
	
	int writeBbs(BbsDto bbs);
	
	int answerBbsUpdate(BbsDto bbs);
	int answerBbsInsert(BbsDto bbs);
	
	int updateBbs(BbsDto bbs);
}
