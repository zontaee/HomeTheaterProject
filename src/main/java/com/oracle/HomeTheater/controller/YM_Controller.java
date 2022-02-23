package com.oracle.HomeTheater.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.service.CH_Service;
import com.oracle.HomeTheater.service.Paging;
import com.oracle.HomeTheater.service.YM_Service;





@Controller
public class YM_Controller {
	@Autowired
	private YM_Service ymService;
	@Autowired
	private CH_Service cs;
	
////main 페이지
//	@RequestMapping(value = "main")
//	public String main() {
//		System.out.println("CH_Contorller main Start...");
//		return "main";
//	}
	
//메인페이지 -> 공지사항클릭
	@RequestMapping(value="YM_views/mainNotice")
	public String mainNotice(Model model,Bbs bbs, String currentPage, HttpServletRequest request) {
		System.out.println("YM_Contorller mainNotice Start...");
		
		System.out.println("YM_Contorller 글작성 버튼에서 넘어온 bbs.getBbs_category()->"+bbs.getBbs_category() );
		
		if(bbs.getBbs_category()==2){
			bbs.setBbs_category(2);
		}else {
			bbs.setBbs_category(1);
		}
		
		
		System.out.println("YM_Contorller mainNotice 연산을 거친  bbs.getBbs_category()->"+bbs.getBbs_category() );
		
		System.out.println("YM_Contorller mainNotice Start list..." );
		int total = ymService.total(bbs);   // Bbs Count -> 42
		System.out.println("YM_Contorller total=>" + total);
		
		//paging		
		System.out.println("currentPage=>" + currentPage);
		//						글수		NULL(0,1.......)2
		Paging pg = new Paging(total, currentPage);
		System.out.println("YM_Contorller pg.getStart()=>" + pg.getStart());
		System.out.println("YM_Contorller pg.getEnd()=>" + pg.getEnd());
		bbs.setStart(pg.getStart());   // 시작시 1
		bbs.setEnd(pg.getEnd());      	//시작시 10
		
		// 검색기능을 위해 추가한 부분
		List<Bbs> listBbs = null;
		String searchValue = request.getParameter("searchValue");
		String selectBox = request.getParameter("selectBox");
		int bbs_category = bbs.getBbs_category();
		
		if(selectBox==null || searchValue==null) {
			listBbs = ymService.listBbs(bbs);
		}else {
			// 검색 조회에 필요한 값들 셋팅
			bbs.setBbs_title(searchValue);
			bbs.setBbs_content(searchValue);
			bbs.setM_id(searchValue);
			bbs.setBbs_category(bbs_category);
			
			if(selectBox.equals("전체")) {
				listBbs = cs.bbsSearchTotal(bbs);
				total = listBbs.size();
			}else if(selectBox.equals("제목")) {
				listBbs = cs.bbsSearchTitle(bbs);
				total = listBbs.size();
			}else if(selectBox.equals("내용")) {
				listBbs = cs.bbsSearchContent(bbs);
				total = listBbs.size();
			}else if(selectBox.equals("작성자")) {
				listBbs = cs.bbsSearchId(bbs);
				total = listBbs.size();
			}
		} // 검색기능을 위해 추가한 부분 end
		
		
		//show list
		System.out.println("YM_Contorller list listBbs.size()=>" + listBbs.size());
		model.addAttribute("total", total);
		model.addAttribute("pg", pg);
		model.addAttribute("listBbs",listBbs);
		
		return "YM_views/mainNotice";
	}
	
//YM_noticeContents 공지사항 내용확인 페이지
	@RequestMapping(value = "YM_views/noticeContents")
	public String noticeContents(Bbs bbs, Model model){
		System.out.println("YM_Contorller noticeContents Start...");
		
		Bbs bbsContents = ymService.noticeContents(bbs);
		
		System.out.println("YM_Contorller noticeContents finsh...");
		
		model.addAttribute("bbsContents",bbsContents);
		
		return "YM_views/noticeContents";
	}



	
//YM_noticeWriteForm 공지사항 글쓰기 페이지폼 호출 컨트롤러
		@RequestMapping(value = "YM_views/noticeWriteForm")
		public String noticeWriteForm(Bbs bbs,Model model){
			System.out.println("YM_Contorller noticeWriteForm Start...");	
			System.out.println("YM_Contorller noticeWriteForm bbs.getBbs_category() ->"+ bbs.getBbs_category());
			System.out.println("YM_Contorller noticeWriteForm finsh...");
		return "YM_views/noticeWriteForm";
		}
//YM_noticeWriteForm에서 입력받은 데이터 처리 컨트롤러
		@RequestMapping(value = "YM_views/noticeWrite", method = RequestMethod.POST )
		public String noticeWrite(Bbs bbs, Model model) {
			System.out.println("YM_Contorller noticeWrite start...");		
			int result = ymService.noticeWrite(bbs);
			System.out.println("YM_Contorller noticeWrite db data input...");		
			if(result>0) {
				return "forward:mainNotice";
			}else {
				model.addAttribute("입력실패 확인해보세요");
				return "forward:noticeWriteForm";
			}
		}
		
//YM_contentsDelete 글삭제
		@RequestMapping(value = "YM_views/contentsDelete")
		public String contentsDelete(Bbs bbs, Model model) {
			System.out.println("YM_Contorller contentsDelete start...");
			int bbsDelete = ymService.contentsDelete(bbs);
			System.out.println("YM_Contorller contentsDelete finsh");	
			return "redirect:mainNotice";
		}

//YM_contentsUpdateForm 글 수정하기위해 수정폼 호출 컨트롤러 및 글내용 입력받기 위한 페이지
// YM_views/mainNotice.jsp -> noticeContents.jsp 수정버튼 클릭 -> contentsUpdateForm.jsp
		@RequestMapping(value="YM_views/contentsUpdateForm")
		public String  contentsUpdateForm(Bbs bbs, Model model){
			System.out.println("YM_Contorller contentsUpdateForm Start...");
			
			//noticeContents.jsp view와 동일한 메소드 사용 
			Bbs bbsContents = ymService.noticeContents(bbs);
			System.out.println("YM_Contorller contentsUpdateForm bbsContents.getBbs_date() ->"+bbsContents.getBbs_date());
			System.out.println("YM_Contorller contentsUpdateForm bbsContents.getBbs_title() ->"+bbsContents.getBbs_title());
			System.out.println("YM_Contorller contentsUpdateForm bbsContents.getBbs_content() ->"+bbsContents.getBbs_content());
			model.addAttribute("bbsContents",bbsContents);
			
			System.out.println("YM_Contorller contentsUpdateForm finish...");
			
			return "YM_views/contentsUpdateForm";
		}
		
//YM_views/contentsUpdateForm.jsp -> 에서 글쓰기 버튼 클릭시 이동		
//YM_contentsUpdate 글 수정 
		@RequestMapping(value = "YM_views/contentsUpdate", method = RequestMethod.POST )
		public String contentsUpdate(Bbs bbs, Model model) {
			System.out.println("YM_Contorller contentsUpdate start...");
			int bbsContentsUpdate = ymService.contentsUpdate(bbs);
			System.out.println("YM_Contorller contentsUpdate db data input bbsContentsUpdate->"+bbsContentsUpdate );		
			if(bbsContentsUpdate>0) {
				System.out.println("YM_Contorller contentsUpdate db data bbsContentsUpdate 성공");		
			    return "redirect:mainNotice";
			}else {
				System.out.println("YM_Contorller contentsUpdate db data bbsContentsUpdate 실패");		
				model.addAttribute("입력실패 확인해보세요");
				return "redirect:mainNotice";
			}
		}
		
}