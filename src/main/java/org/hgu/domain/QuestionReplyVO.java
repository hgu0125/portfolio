package org.hgu.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionReplyVO {
	private Long rno;
	private Long bno;
	private String id;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
