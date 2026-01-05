package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.vo.JejuVO;
import com.sist.web.vo.SeoulVO;

public interface JejuService {
	public List<JejuVO> jejuListData(Map map);
	public int jejuTotalPage(int contenttype);
	public JejuVO jejuAttractionDetailData(int contentid);
}
