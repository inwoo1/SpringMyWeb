package com.coding404.util;

import lombok.Data;

@Data
public class Criteria {

	private int pageNum;
	private int amount;
	//검색 키워드 추가
	
	private String searchName;
	private String searchType;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
 }
