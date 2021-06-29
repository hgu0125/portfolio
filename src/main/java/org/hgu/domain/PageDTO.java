package org.hgu.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO { // 페이지 번호
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) { // total : 전체 데이터 수
		this.cri = cri;
		this.total = total;
		
		// 페이지 끝 번호(현재 페이지 기준임. 마지막 페이지 번호 ㄴㄴ)
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;
		if(this.endPage<10)
			this.startPage = 1;
		// 마지막 페이지 번호
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd<this.endPage){
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	} // 생성자 끝
}
