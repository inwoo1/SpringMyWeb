package com.coding404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컴포넌트 스캔
@RequestMapping("/freeBoard")
public class FreeBoardController {

	//화면처리
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	@RequestMapping("/freeList")
	public String freeList() {
		return "freeBoard/freeList";
	}
	
	@RequestMapping("/freeDetail")
	public String freeDetail() {
		return "freeBoard/freeDetail";
	}
	
	@RequestMapping("/freeModify")
	public String freeModify() {
		return "freeBoard/freeModify";
	}
 }
