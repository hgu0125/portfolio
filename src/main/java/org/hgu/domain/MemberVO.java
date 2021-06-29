package org.hgu.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private Date join_date;
	
}

