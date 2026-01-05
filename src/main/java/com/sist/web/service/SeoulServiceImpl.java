package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;

@Service
@RequiredArgsConstructor
public class SeoulServiceImpl implements SeoulService{
	private final SeoulMapper mapper;
	
	/*
	@Autowired
	public SeoulServiceImpl(SeoulMapper mapper) {
		this.mapper=mapper;
	}
	 */

	@Override
	public List<SeoulVO> seoulLocationListData(int start) {
		// TODO Auto-generated method stub
		return mapper.seoulLocationListData(start);
	}

	@Override
	public int seoulLocationTotalPage() {
		// TODO Auto-generated method stub
		return mapper.seoulLocationTotalPage();
	}
}
