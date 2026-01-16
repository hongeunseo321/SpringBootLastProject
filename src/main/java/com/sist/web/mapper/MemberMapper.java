package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface MemberMapper {
	// ID 중복 체크
	@Select("SELECT COUNT(*) FROM project_member_2 " + "WHERE userid=#{userid}")
	public int memberIdCheck(String userid);

	/*
	 * USERID NOT NULL VARCHAR2(20) USERNAME NOT NULL VARCHAR2(50) USERPWD NOT NULL
	 * VARCHAR2(300) ENABLED NUMBER(1) SEX VARCHAR2(6) BIRTHDAY NOT NULL
	 * VARCHAR2(20) EMAIL VARCHAR2(100) POST NOT NULL VARCHAR2(10) ADDR1 NOT NULL
	 * VARCHAR2(300) ADDR2 VARCHAR2(300) PHONE VARCHAR2(20) CONTENT CLOB REGDATE
	 * DATE
	 */
	@Insert("INSERT INTO project_member_2(userid,username,userpwd,"
			+ "sex,birthday,email,post,addr1,addr2,phone,content) " + "VALUES(#{userid},#{username},#{userpwd},#{sex},"
			+ "#{birthday},#{email},#{post},#{addr1}," + "#{addr2},#{phone},#{content})")
	public void memberInsert(MemberVO vo);

	@Insert("INSERT INTO authority_2 VALUES(" + "#{userid},'ROLE_USER')")
	public void memberAuthorityInsert(String userid);

	// 비밀번호 검사 => 데이터 읽기 => session 저장
	@Select("SELECT * FROM project_member_2 " + "WHERE userid=#{userid}")
	public MemberVO memberInfodData(String userid);

}