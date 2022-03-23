package com.coding404.freeboard.service;

import java.util.ArrayList;

import com.coding404.command.FreeBoardVO;

public interface FreeBoardMapper {
	
	public int regist(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> getList();
	public FreeBoardVO getContent(int bno);
	public int update(FreeBoardVO bno);
	public int delete(int bno);
}
