package com.coding404.util;

import lombok.Data;

@Data
public class PageVO {
	//페이지네이션을 그리는 역할
	
	private int startPage;
	private int endPage;
	private boolean prev; //이전버튼
	private boolean next; //다음버튼
	
	private int pageNum;
	private int amount;
	private int total; //전체 게시글 수
	
	private Criteria cri; //페이지 기준?
	
	public PageVO(Criteria cri, int total) {
		this.pageNum = cri.getPageNum();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		//페이지계산
		//끝페이지 계산
		//pageNum이 11이라면, 페이지네이션 끝번호는 20이어야 함
		//(int)Math.ceil( 조회하는 페이지 번호 / 페이지네이션 수) * 페이지네이션 수
		this.endPage = (int)Math.ceil( this.pageNum / 10.0) * 10;
		
		//첫페이지 계산
		//시작페이지는 = 페이지네이션 끝번호 - 페이지네이션 수 +1
		this.startPage = this.endPage -10 + 1;
		
		//실제 끝번호
		//총 게시글 수가 54 ? 마지막 페이지네이션은 6  총 게시글 수 112개 ? 마지막 페이지네이션 12
		//(int)Math.ceil( 총게시글수 / 화면에뿌려지는 amount값)
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		//실제 끝페이지의 결정
		//  endPage 10   = realEnd 12   ?  10
		//  endPage 15    =  realEnd 12 ?  12
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		//이전버튼 활성화 여부
		//startPage가 1, 11 ,21 ,31  ...... 1보다 클때 활성화
		this.prev = this.startPage > 1;
		
		//다음버튼 활성화 여부
		//realEnd가 12이고, endPage가 10일 때 true 
		this.next = realEnd > this.endPage;
		
				
	}

}
