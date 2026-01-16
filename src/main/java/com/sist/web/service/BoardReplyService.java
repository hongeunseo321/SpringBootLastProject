package com.sist.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.web.vo.BoardReplyVO;

public interface BoardReplyService {
	/*
	 * @Select("SELECT no,bno,id,name,sex,msg,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday "
	 * +"FROM board_reply " +"WHERE bno=#{bno}")
	 */
	public List<BoardReplyVO> boardReplyListData(int bno);

	/*
	 * @Select("SELECT COUNT(*) FROM board_reply " +"WHERE bno=#{bno}")
	 */
	public int boardReplyCount(int bno);

	public void boardReplyInsert(BoardReplyVO vo);
	
	 public void boardReplyUpdate(BoardReplyVO vo);
}