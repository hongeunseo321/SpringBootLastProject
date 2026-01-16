package com.sist.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.web.vo.BoardVO;

// 1. 게시판 / 댓글 
public interface BoardService {
	/*
	 * @Select("SELECT no,subject,name,hit,replycount,"
	 * +"TO_CHAR(regdate,'yyyy-mm-dd') as dbday " +"FROM board "
	 * +"ORDER BY no DESC " +"OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	 */
	public List<BoardVO> boardListData(int start);

	// @Select("SELECT CEIL(COUNT(*)/12.0) FROM board")
	public int boardTotalPage();

	/*
	 * @Insert("INSERT INTO board VALUES("
	 * +"#{no},#{name},#{subject},#{content},#{pwd},SYSDATE,0,0)")
	 */
	public void boardInsert(BoardVO vo);

	/*
	 * @Select("SELECT no,name,subject,content,hit,"
	 * +"TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday " +"FROM board "
	 * +"WHERE no=#{no}")
	 */
	public BoardVO boardDetailData(int no);

	public BoardVO boardUpdateData(int no);

	public String boardUpdate(BoardVO vo);

	public boolean boardDelete(int no, String pwd);

	/*
	 * @Update("UPDATE board SET " +"replycount=#{replycount} " +"WHERE no=#{no}")
	 */
	// public void boardReplyCountUpdate(int replycount,int no);

}