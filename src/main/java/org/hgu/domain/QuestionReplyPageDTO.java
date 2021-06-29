package org.hgu.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class QuestionReplyPageDTO {

	private int replyCnt;
	private List<QuestionReplyVO> list;
	
}
