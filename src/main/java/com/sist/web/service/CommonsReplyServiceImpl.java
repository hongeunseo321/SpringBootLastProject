package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
/*
 * 	# Service: DataBase, OpenAPI, AI
 * 		=> 요청처리
 * 		=> Security: BI
 * 		=> Back-End의 중심
 * 
 *  # Repository: 오라클 / MySQL만 연동
 *  	=> DispatcherServlet: 요청/응답 => FrontController
 *  
 *  # Controller: 결괏값을 받아서 브라우저로 전송
 *  	=> 라우터 역할
 *  	=> Front-End
 *  	=> 조립해서 결괏값 추출
 *  
 *  # RestController: 데이터 전송
 *  
 *  # Component: 기타
 *  	=> AOP / Task / Batch
 *  
 *  	
 *  Service ====== Client
 *   ㄴ순수하게 서버 역할만... (화면 제어 X)
 *   	Front에서 자체 처리 => router
 *   						Vue/React로 처리
 */
import org.springframework.transaction.annotation.Transactional;

import com.sist.web.mapper.CommonsReplyMapper;
import com.sist.web.vo.CommonsReplyVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CommonsReplyServiceImpl implements CommonsReplyService{
	private final CommonsReplyMapper mapper;

	@Override
	public List<CommonsReplyVO> commonsReplyListData(int cno, int start) {
		// TODO Auto-generated method stub
		return mapper.commonsReplyListData(cno, start);
	}

	@Override
	public int commonsReplyTotalPage(int cno) {
		// TODO Auto-generated method stub
		return mapper.commonsReplyTotalPage(cno);
	}

	@Override
	public void commonsReplyInsert(CommonsReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.commonsReplyInsert(vo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void commonsDelete(int no) {
		// TODO Auto-generated method stub
		CommonsReplyVO vo=mapper.commonsInfoData(no);
		if(vo.getDepth()==0) {
			mapper.commonsDelete(no);
		} else {
			CommonsReplyVO rvo=new CommonsReplyVO();
			rvo.setNo(no);
			rvo.setMsg("관리자가 삭제한 댓글입니다.");
			mapper.commonsMsgUpdate(rvo);
		}
		mapper.commonsDepthDecrement(vo.getRoot());
	}
	
}
