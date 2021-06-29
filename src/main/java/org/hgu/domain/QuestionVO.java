package org.hgu.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class QuestionVO {
	private Long bno;
	private String id;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private int replyCnt;
	private int recommend;
	private int hit;
	private List<QuestionAttachVO> attachList;
}
