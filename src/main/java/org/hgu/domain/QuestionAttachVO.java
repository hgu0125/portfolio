package org.hgu.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionAttachVO {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private Long bno;
	private Date regdate;
	
}
