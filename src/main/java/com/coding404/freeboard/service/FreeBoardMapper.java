package com.coding404.freeboard.service;

import java.util.ArrayList;

import com.coding404.command.FreeBoardVO;
import com.coding404.util.Criteria;

public interface FreeBoardMapper {
	
	public int regist(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> getList(Criteria cri);
	public FreeBoardVO getContent(int bno);
	public int getTotal(Criteria cri);
	
	public int update(FreeBoardVO bno);
	public int delete(int bno);
}
