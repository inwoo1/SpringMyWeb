package com.coding404.freeboard.service;

import java.util.ArrayList;

import com.coding404.command.FreeBoardVO;
import com.coding404.util.Criteria;

public interface FreeBoardService {

	public int regist(FreeBoardVO vo); //등록
	public ArrayList<FreeBoardVO> getList(Criteria cri);
	public FreeBoardVO getContent(int bno);
	public int getTotal(Criteria cri);//전체 게시글 수
	
	public int update(FreeBoardVO vo);
	public int delete(int bno);
}
