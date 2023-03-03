package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	List<BbsDto> bbsList(BbsParam param);
	int getAllBbs(BbsParam param);

}
