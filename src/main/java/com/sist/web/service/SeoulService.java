package com.sist.web.service;
import java.util.*;
import com.sist.web.vo.*;
/*
 *  user 요청  ===============>  DispatcherServlet
 *  		  /seoul/location	|# 위임
 *  						   HandlerMapping
 *  							|# URI 주소 찾기
 *  							|	ㄴ@GetMapping
 *  							|	ㄴ@PostMapping
 *  							|	ㄴ@PutMapping
 *  							|	ㄴ@DeleteMapping
 *  							|
 *  							|# 밑에 있는 메소드 호출
 *  							|	ㄴService
 *  							|		|
 *  							|	ㄴMapper => 수정 시에 의존성을 약하게
 *  							|		|
 *  							|	ㄴ오라클
 *  							|
 *  						   DispatcherServlet
 *  							|
 *  						   ViewResolver
 *  							|
 *  						   JSP
 */
public interface SeoulService {
	public List<SeoulVO> seoulListData(Map map);
	public int seoulTotalPage(int contenttype);
}
