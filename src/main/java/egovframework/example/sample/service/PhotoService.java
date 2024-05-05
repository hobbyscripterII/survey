package egovframework.example.sample.service;

import java.util.List;

import egovframework.example.cmmn.Pagination.Criteria;
import egovframework.example.sample.service.model.PhotoInsNullDto;
import egovframework.example.sample.service.model.PhotoListGetVo;

public interface PhotoService {
	public List<PhotoListGetVo> getPhotoBoardList(Criteria criteria);
	int getPhotoBoardListCnt(Criteria criteria);
	int insPhotoBoardNull(PhotoInsNullDto dto);
}