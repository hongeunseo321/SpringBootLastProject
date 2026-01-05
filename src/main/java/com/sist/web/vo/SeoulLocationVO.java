package com.sist.web.vo;

import lombok.Data;

/*
이름         널? 유형             
---------- -- -------------- 
NO            NUMBER         
CONTENTID     NUMBER         
INFOCENTER    VARCHAR2(1024) 
RESTDATE      VARCHAR2(1024) 
USETIME       VARCHAR2(1024) 
PARKING       VARCHAR2(1024) 
MSG           CLOB           
 */

@Data
public class SeoulLocationVO {
	private int no,contentid;
	private String infocenter,restdate,usetime,parking,msg;
}
