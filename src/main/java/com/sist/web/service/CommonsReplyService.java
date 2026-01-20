package com.sist.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Delete;

import com.sist.web.vo.*;

public interface CommonsReplyService {
	public List<CommonsReplyVO> commonsReplyListData(int cno, int start);

	public int commonsReplyTotalPage(int cno);

	public void commonsReplyInsert(CommonsReplyVO vo);

	public void commonsMsgUpdate(CommonsReplyVO vo);

	public void commonsDelete(int no);
	
	public void commonsReplyReplyInsert(CommonsReplyVO vo);
}
