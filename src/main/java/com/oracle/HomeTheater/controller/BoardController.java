package com.oracle.HomeTheater.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.webMethod.BoardMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.oracle.HomeTheater.service.MemberService;
import com.oracle.HomeTheater.service.Paging;
import com.oracle.HomeTheater.service.BoardService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final BoardMethod boardMethod;

    //메인페이지 -> 공지사항클릭(MY BATIS)
    @RequestMapping(value = "Board/mainNotice")
    public String mainNotice(Model model, Board board, String currentPage, HttpServletRequest request) {
        System.out.println("BoardContorller mainNotice Start...");

        System.out.println("BoardContorller 글작성 버튼에서 넘어온 board.getboard_category()->" + board.getBoard_category());

        if (board.getBoard_category() == 2) {
            board.setBoard_category(2);
        } else {
            board.setBoard_category(1);
        }
        System.out.println("BoardContorller mainNotice 연산을 거친  board.getboard_category()->" + board.getBoard_category());

        System.out.println("BoardContorller mainNotice Start list...");
        int total = boardService.total(board);   // board Count -> 42
        System.out.println("BoardContorller total=>" + total);

        //paging
        System.out.println("currentPage=>" + currentPage);
        //						글수		NULL(0,1.......)2
        Paging pg = new Paging(total, currentPage);
        System.out.println("BoardContorller pg.getStart()=>" + pg.getStart());
        System.out.println("BoardContorller pg.getEnd()=>" + pg.getEnd());
        board.setStart(pg.getStart());   // 시작시 1
        board.setEnd(pg.getEnd());        //시작시 10

        // 검색기능을 위해 추가한 부분
        List<Board> listboard = null;
        String searchValue = request.getParameter("searchValue");
        String selectBox = request.getParameter("selectBox");
        int board_category = board.getBoard_category();

        if (selectBox == null || searchValue == null) {
            listboard = boardService.listboard(board);
        } else {
            // 검색 조회에 필요한 값들 셋팅
            board.setBoard_title(searchValue);
            board.setBoard_content(searchValue);
            board.setM_id(searchValue);
            board.setBoard_category(board_category);

            if (selectBox.equals("전체")) {
                listboard = memberService.boardSearchTotal(board);
                total = listboard.size();
            } else if (selectBox.equals("제목")) {
                listboard = memberService.boardSearchTitle(board);
                total = listboard.size();
            } else if (selectBox.equals("내용")) {
                listboard = memberService.boardSearchContent(board);
                total = listboard.size();
            } else if (selectBox.equals("작성자")) {
                listboard = memberService.boardSearchId(board);
                total = listboard.size();
            }
        } // 검색기능을 위해 추가한 부분 end


        //show list
        System.out.println("BoardContorller list listboard.size()=>" + listboard.size());
        model.addAttribute("total", total);
        model.addAttribute("pg", pg);
        model.addAttribute("listboard", listboard);

        return "Board/mainNotice";
    }

    /**
     * 게시글 리스트 표시 및 페이징
     * @param pageable
     * @param board
     * @param model
     * @return
     */
    @GetMapping("Board/boardList")
    public String boardList(@PageableDefault() Pageable pageable, Board board,
                            Model model) {
        log.info("Boardcontroller boardList start");
        boardMethod.BoardCategorySetting(board);
        Page<Board> boardList = boardService.listboardJpa(pageable, board);
        model.addAttribute("boardList", boardList);
        return "thymeleaf/Board/mainNoticeJpa";
    }


    /**
     * 게시글 상세보기
     * @param boardNo
     * @param model
     * @return
     */
    @GetMapping(value = "Board/noticeContents/{boardNo}")
    public String noticeContents(@PathVariable Long boardNo, Model model) {
        log.info("BoardContorller noticeContents Start...");
        Board board = boardMethod.boardNoSetting(boardNo);
        Board boardContents = boardService.noticeContents(board);
        model.addAttribute("boardContents", boardContents);
        return "Board/noticeContents";
    }

    /**
     * 게시글 생성  get controller
     * @return
     */
    @GetMapping(value = "Board/noticeWriteForm")
    public String noticeWriteForm(Board board, Model model) {
        log.info("BoardContorller noticeWriteForm Start...");
        model.addAttribute("board",board);
        return "Board/noticeWriteForm";
    }

    /**
     * 게시글 생성  post contorller
     * @param board
     * @param loginMember
     * @return
     */
    @PostMapping(value = "Board/noticeWrite")
    public String noticeWrite(Board board,
                              @SessionAttribute(name = "sessionId", required = false)
                                      String loginMember) {
        log.info("BoardContorller noticeWrite start...");
        boardService.noticeWrite(board, loginMember);
        return "redirect:/Board/boardList";
    }

    /**
     * 기세글 삭제
     * @param board
     * @return
     */
    @RequestMapping(value = "contentsDelete")
    public String contentsDelete(Board board) {
        log.info("BoardContorller contentsDelete start...");
        boardService.contentsDelete(board);
        return "redirect:Board/boardList";
    }

    /**
     * 게시글 수정 Get contorller
     * @param board
     * @param model
     * @return
     */
    @GetMapping(value = "contentsUpdateForm")
    public String contentsUpdateForm(Board board, Model model) {
        log.info("BoardContorller contentsUpdateForm Start...");
        Board boardContents = boardService.noticeContents(board);
        model.addAttribute("boardContents", boardContents);
        return "Board/contentsUpdateForm";
    }

    /**
     * 게시글 수정  post contorller
     * @param board
     * @return
     */
    @RequestMapping(value = "contentsUpdate", method = RequestMethod.POST)
    public String contentsUpdate(Board board) {
        log.info("BoardContorller contentsUpdate start...");
        boardService.contentsUpdate(board);
        return "redirect:Board/boardList";
    }

}