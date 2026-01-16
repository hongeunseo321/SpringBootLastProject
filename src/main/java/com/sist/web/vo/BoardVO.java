package com.sist.web.vo;

import java.util.Date;

import lombok.Data;
// CRUD 모든 사이트의 필수
// 댓글은 옵션
@Data
public class BoardVO {
	private int no,hit,replycount;
	private String name,subject,content,dbday,pwd;
	private Date regdate;
}
