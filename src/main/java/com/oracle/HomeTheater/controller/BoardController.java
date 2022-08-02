package com.oracle.HomeTheater.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.HomeTheater.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String mainNotice(Model model, Board board, String currentPage, HttpServletRequest request) {
		System.out.println("BoardContorller mainNotice Start...");
		
		System.out.println("BoardContorller 글작성 버튼에서 넘어온 board.getboard_category()->"+ board.getBoard_category() );
		
		if(board.getBoard_category()==2){
			board.setBoard_category(2);
		}else {
			board.setBoard_category(1);
		}
		
		
		System.out.println("BoardContorller mainNotice 연산을 거친  board.getboard_category()->"+ board.getBoard_category() );
		
		System.out.println("BoardContorller mainNotice Start list..." );
		int total = ymService.total(board);   // board Count -> 42
		System.out.println("BoardContorller total=>" + total);
		
		//paging		
		System.out.println("currentPage=>" + currentPage);
		//						글수		NULL(0,1.......)2
		Paging pg = new Paging(total, currentPage);
		System.out.println("BoardContorller pg.getStart()=>" + pg.getStart());
		System.out.println("BoardContorller pg.getEnd()=>" + pg.getEnd());
		board.setStart(pg.getStart());   // 시작시 1
		board.setEnd(pg.getEnd());      	//시작시 10
		
		// 검색기능을 위해 추가한 부분
		List<Board> listboard = null;
		String searchValue = request.getParameter("searchValue");
		String selectBox = request.getParameter("selectBox");
		int board_category = board.getBoard_category();
		
		if(selectBox==null || searchValue==null) {
			listboard = ymService.listboard(board);
		}else {
			// 검색 조회에 필요한 값들 셋팅
			board.setBoard_title(searchValue);
			board.setBoard_content(searchValue);
			board.setM_id(searchValue);
			board.setBoard_category(board_category);
			
			if(selectBox.equals("전체")) {
				listboard = cs.boardSearchTotal(board);
				total = listboard.size();
			}else if(selectBox.equals("제목")) {
				listboard = cs.boardSearchTitle(board);
				total = listboard.size();
			}else if(selectBox.equals("내용")) {
				listboard = cs.boardSearchContent(board);
				total = listboard.size();
			}else if(selectBox.equals("작성자")) {
				listboard = cs.boardSearchId(board);
				total = listboard.size();
			}
		} // 검색기능을 위해 추가한 부분 end
		
		
		//show list
		System.out.println("BoardContorller list listboard.size()=>" + listboard.size());
		model.addAttribute("total", total);
		model.addAttribute("pg", pg);
		model.addAttribute("listboard",listboard);
		
		return "Board/mainNotice";
	}
	
//BoardnoticeContents 공지사항 내용확인 페이지
	@RequestMapping(value = "Board/noticeContents")
	public String noticeContents(Board board, Model model){
		System.out.println("BoardContorller noticeContents Start...");
		System.out.println("Board" + board.toString());
		
		Board boardContents = ymService.noticeContents(board);

		System.out.println("BoardContorller noticeContents finsh...");
		
		model.addAttribute("boardContents", boardContents);
		
		return "Board/noticeContents";
	}



	
//BoardnoticeWriteForm 공지사항 글쓰기 페이지폼 호출 컨트롤러
		@RequestMapping(value = "Board/noticeWriteForm")
		public String noticeWriteForm(Board board, Model model){
			System.out.println("BoardContorller noticeWriteForm Start...");	
			System.out.println("BoardContorller noticeWriteForm board.getboard_category() ->"+ board.getBoard_category());
			System.out.println("BoardContorller noticeWriteForm finsh...");
		return "Board/noticeWriteForm";
		}
//BoardnoticeWriteForm에서 입력받은 데이터 처리 컨트롤러
		@RequestMapping(value = "Board/noticeWrite", method = RequestMethod.POST )
		public String noticeWrite(Board board, Model model) {
			System.out.println("BoardContorller noticeWrite start...");		
			int result = ymService.noticeWrite(board);
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
		public String contentsDelete(Board board, Model model) {
			System.out.println("BoardContorller contentsDelete start...");
			int boardDelete = ymService.contentsDelete(board);
			System.out.println("BoardContorller contentsDelete finsh");	
			return "redirect:mainNotice";
		}

//BoardcontentsUpdateForm 글 수정하기위해 수정폼 호출 컨트롤러 및 글내용 입력받기 위한 페이지
// Board/mainNotice.jsp -> noticeContents.jsp 수정버튼 클릭 -> contentsUpdateForm.jsp
		@RequestMapping(value="Board/contentsUpdateForm")
		public String  contentsUpdateForm(Board board, Model model){
			System.out.println("BoardContorller contentsUpdateForm Start...");
			
			//noticeContents.jsp 와 동일한 메소드 사용 
			Board boardContents = ymService.noticeContents(board);
			System.out.println("BoardContorller contentsUpdateForm boardContents.getboard_date() ->"+ boardContents.getBoard_date());
			System.out.println("BoardContorller contentsUpdateForm boardContents.getboard_title() ->"+ boardContents.getBoard_title());
			System.out.println("BoardContorller contentsUpdateForm boardContents.getboard_content() ->"+ boardContents.getBoard_content());
			model.addAttribute("boardContents", boardContents);
			
			System.out.println("BoardContorller contentsUpdateForm finish...");
			
			return "Board/contentsUpdateForm";
		}
		
//Board/contentsUpdateForm.jsp -> 에서 글쓰기 버튼 클릭시 이동		
//BoardcontentsUpdate 글 수정 
		@RequestMapping(value = "Board/contentsUpdate", method = RequestMethod.POST )
		public String contentsUpdate(Board board, Model model) {
			System.out.println("BoardContorller contentsUpdate start...");
			int boardContentsUpdate = ymService.contentsUpdate(board);
			System.out.println("BoardContorller contentsUpdate db data input boardContentsUpdate->"+boardContentsUpdate );		
			if(boardContentsUpdate>0) {
				System.out.println("BoardContorller contentsUpdate db data boardContentsUpdate 성공");		
			    return "redirect:mainNotice";
			}else {
				System.out.println("BoardContorller contentsUpdate db data boardContentsUpdate 실패");		
				model.addAttribute("입력실패 확인해보세요");
				return "redirect:mainNotice";
			}
		}
		
}