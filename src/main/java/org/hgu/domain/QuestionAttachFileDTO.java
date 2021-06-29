package org.hgu.domain;

import lombok.Data;

@Data
public class QuestionAttachFileDTO {

	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	
}
