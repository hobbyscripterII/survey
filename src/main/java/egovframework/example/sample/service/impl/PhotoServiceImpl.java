package egovframework.example.sample.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.PhotoService;
import egovframework.example.sample.service.model.PhotoListGetVo;

@Service
public class PhotoServiceImpl implements PhotoService {
	private final PhotoMapper photoMapper;
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public PhotoServiceImpl(PhotoMapper photoMapper) { this.photoMapper = photoMapper; }
	
	@Override
	public List<PhotoListGetVo> getPhotoBoardList() {
		return photoMapper.getPhotoBoardList();
	}
}