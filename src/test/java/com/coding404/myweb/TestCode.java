package com.coding404.myweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coding404.command.FreeBoardVO;
import com.coding404.freeboard.service.FreeBoardMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class TestCode {

	@Autowired
	FreeBoardMapper freeboardMapper;
	
	@Test
	public void testCode01() {
		
		for(int i = 1; i < 300; i++) {
			
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("test"+ i);
		vo.setWriter("admin" + i);
		vo.setContent("test" + i);
		freeboardMapper.regist(vo);
		
		}
		
	}
	
}
