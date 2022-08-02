package com.oracle.HomeTheater.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.service.MemberService;
import com.oracle.HomeTheater.service.Paging;
import com.oracle.HomeTheater.service.BoardService;





@Controller
public class BoardController {
	@Autowired
	private BoardService ymService;
	@Autowired
	private MemberService cs;
	
////main 페이지
//	@RequestMapping(value = "main")
//	public String main() {
//		System.out.println("MemberContorller main Start...");
//		return "main";
//	}
	
//메인페이지 -> 공지사항클릭
	@RequestMapping(value="Board/mainNotice")
	public String mainNotice(Model model,Bbs bbs, String currentPage, HttpServletRequest request) {
		System.out.println("BoardContorller mainNotice Start...");
		
		System.out.println("BoardContorller 글작성 버튼에서 넘어온 bbs.getBbs_category()->"+bbs.getBbs_category() );
		
		if(bbs.getBbs_category()==2){
			bbs.setBbs_category(2);
		}else {
			bbs.setBbs_category(1);
		}
		
		
		System.out.println("BoardContorller mainNotice 연산을 거친  bbs.getBbs_category()->"+bbs.getBbs_category() );
		
		System.out.println("BoardContorller mainNotice Start list..." );
		int total = ymService.total(bbs);   // Bbs Count -> 42
		System.out.println("BoardContorller total=>" + total);
		
		//paging		
		System.out.println("currentPage=>" + currentPage);
		//						글수		NULL(0,1.......)2
		Paging pg = new Paging(total, currentPage);
		System.out.println("BoardContorller pg.getStart()=>" + pg.getStart());
		System.out.println("BoardContorller pg.getEnd()=>" + pg.getEnd());
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
		System.out.println("BoardContorller list listBbs.size()=>" + listBbs.size());
		model.addAttribute("total", total);
		model.addAttribute("pg", pg);
		model.addAttribute("listBbs",listBbs);
		
		return "Board/mainNotice";
	}
	
//BoardnoticeContents 공지사항 내용확인 페이지
	@RequestMapping(value = "Board/noticeContents")
	public String noticeContents(Bbs bbs, Model model){
		System.out.println("BoardContorller noticeContents Start...");
		
		Bbs bbsContents = ymService.noticeContents(bbs);
		
		System.out.println("BoardContorller noticeContents finsh...");
		
		model.addAttribute("bbsContents",bbsContents);
		
		return "Board/noticeContents";
	}



	
//BoardnoticeWriteForm 공지사항 글쓰기 페이지폼 호출 컨트롤러
		@RequestMapping(value = "Board/noticeWriteForm")
		public String noticeWriteForm(Bbs bbs,Model model){
			System.out.println("BoardContorller noticeWriteForm Start...");	
			System.out.println("BoardContorller noticeWriteForm bbs.getBbs_category() ->"+ bbs.getBbs_category());
			System.out.println("BoardContorller noticeWriteForm finsh...");
		return "Board/noticeWriteForm";
		}
//BoardnoticeWriteForm에서 입력받은 데이터 처리 컨트롤러
		@RequestMapping(value = "Board/noticeWrite", method = RequestMethod.POST )
		public String noticeWrite(Bbs bbs, Model model) {
			System.out.println("BoardContorller noticeWrite start...");		
			int result = ymService.noticeWrite(bbs);
			System.out.println("BoardContorller noticeWrite db data input...");		
			if(result>0) {
				return "forward:mainNotice";
			}else {
				model.addAttribute("입력실패 확인해보세요");
				return "forward:noticeWriteForm";
			}
		}
		
//BoardcontentsDelete 글삭제
		@RequestMapping(value = "Board/contentsDelete")
		public String contentsDelete(Bbs bbs, Model model) {
			System.out.println("BoardContorller contentsDelete start...");
			int bbsDelete = ymService.contentsDelete(bbs);
			System.out.println("BoardContorller contentsDelete finsh");	
			return "redirect:mainNotice";
		}

//BoardcontentsUpdateForm 글 수정하기위해 수정폼 호출 컨트롤러 및 글내용 입력받기 위한 페이지
// Board/mainNotice.jsp -> noticeContents.jsp 수정버튼 클릭 -> contentsUpdateForm.jsp
		@RequestMapping(value="Board/contentsUpdateForm")
		public String  contentsUpdateForm(Bbs bbs, Model model){
			System.out.println("BoardContorller contentsUpdateForm Start...");
			
			//noticeContents.jsp 와 동일한 메소드 사용 
			Bbs bbsContents = ymService.noticeContents(bbs);
			System.out.println("BoardContorller contentsUpdateForm bbsContents.getBbs_date() ->"+bbsContents.getBbs_date());
			System.out.println("BoardContorller contentsUpdateForm bbsContents.getBbs_title() ->"+bbsContents.getBbs_title());
			System.out.println("BoardContorller contentsUpdateForm bbsContents.getBbs_content() ->"+bbsContents.getBbs_content());
			model.addAttribute("bbsContents",bbsContents);
			
			System.out.println("BoardContorller contentsUpdateForm finish...");
			
			return "Board/contentsUpdateForm";
		}
		
//Board/contentsUpdateForm.jsp -> 에서 글쓰기 버튼 클릭시 이동		
//BoardcontentsUpdate 글 수정 
		@RequestMapping(value = "Board/contentsUpdate", method = RequestMethod.POST )
		public String contentsUpdate(Bbs bbs, Model model) {
			System.out.println("BoardContorller contentsUpdate start...");
			int bbsContentsUpdate = ymService.contentsUpdate(bbs);
			System.out.println("BoardContorller contentsUpdate db data input bbsContentsUpdate->"+bbsContentsUpdate );		
			if(bbsContentsUpdate>0) {
				System.out.println("BoardContorller contentsUpdate db data bbsContentsUpdate 성공");		
			    return "redirect:mainNotice";
			}else {
				System.out.println("BoardContorller contentsUpdate db data bbsContentsUpdate 실패");		
				model.addAttribute("입력실패 확인해보세요");
				return "redirect:mainNotice";
			}
		}
		
}