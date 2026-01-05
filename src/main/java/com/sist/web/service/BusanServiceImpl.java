package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;

@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService{
	private final BusanMapper mapper;
	
	@Override
	public List<BusanVO> busanListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.busanListData(map);
	}

	@Override
	public int busanTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return mapper.busanTotalPage(contenttype);
	}

}
