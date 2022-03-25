package com.coding404.controller;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.command.FreeBoardVO;
import com.coding404.freeboard.service.FreeBoardService;
import com.coding404.util.Criteria;
import com.coding404.util.PageVO;

@Controller //컴포넌트 스캔
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("freeBoardService")
	FreeBoardService freeBoardService;

	//화면처리
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	@RequestMapping("/freeList")
	public String freeList(Model model, Criteria cri) {
		
		System.out.println(cri.toString());
		
		//페이지가 없는 모형
//		ArrayList<FreeBoardVO> list = freeBoardService.getList();
		//페이지가 있는 모형
		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
		
		//페이지네이션 생성
		int total = freeBoardService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		return "freeBoard/freeList";
	}
	
//	@RequestMapping("/freeDetail")
//	public String freeDetail(@RequestParam("bno") int bno,
//							 Model model) {
//		
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		return "freeBoard/freeDetail";
//	}
//	
//	@RequestMapping("/freeModify")
//	public String freeModify(@RequestParam("bno") int bno,
//								Model model) {
//		
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		return "freeBoard/freeModify";
//	}
	//화면처리(ex 상세보기,수정하기화면) 기능이 완전히 같다면 묶어서 사용할 수 있다
	@RequestMapping({"/freeDetail" , "/freeModify"})
	public void getContent(@RequestParam("bno") int bno, Model model) {
		
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value = "/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		int result = freeBoardService.regist(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글이 등록 되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "게시글 등록에 실패했습니다.");
		}
		
		return "redirect:/freeBoard/freeList";  //리다이렉트
	}
	
	//updateForm
	@RequestMapping("/updateForm")
	public String updateForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		/*
		 * 화면에서 넘어오는 데이터 받기 vo
		 * update 메서드 생성, 업데이트 작업 수행
		 * 성공실패 결과를 받아서, 성공시에 메세지와 함께 리스트화면으로 redirect
		 * 실패시에도 실패 메세지와 함께 리스트화면으로 redirect
		 */
		int result = freeBoardService.update(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글이 수정되었습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글 수정에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	@RequestMapping(value = "/deleteForm" , method = RequestMethod.POST)
	public String deleteForm(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		/*
		 * bno로 삭제를 진행
		 * 삭제성공시 메세지, list로 리다이렉트
		 * 삭제실패시 메세지, Modify로 리다이렉트
		 */
		int result = freeBoardService.delete(bno);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글이 삭제 되었습니다");
			return "redirect:/freeBoard/freeList";
		}else {
			RA.addFlashAttribute("msg", "게시글 삭제에 실패 했습니다");
			return "redirect:/freeBoard/freeModify?bno=" + bno;
		}
		
		
	}
	
 }
