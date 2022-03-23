package com.coding404.freeboard.service;

import java.util.ArrayList;

import com.coding404.command.FreeBoardVO;

public interface FreeBoardService {

	public int regist(FreeBoardVO vo); //등록
	public ArrayList<FreeBoardVO> getList();
	public FreeBoardVO getContent(int bno);
	public int update(FreeBoardVO vo);
	public int delete(int bno);
}
