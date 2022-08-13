package com.oracle.HomeTheater.webMethod;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class BoardMethod {
    private final MemberRepository memberRepository;

    /**
     * board null check
     * @param board
     */
    public void boardNullCheck(Board board) {
        try{
            if(board == null) {
                throw new NullPointerException("board == null");
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    /**
     * MemberSetting
     * @param loginMember
     * @param boardJpa
     */
    public void BoardMemberSetting(String loginMember, BoardJpa boardJpa) {
        Optional<MemberJpa> memberJpa = memberRepository.findById(loginMember);
        boardJpa.addMember(memberJpa.get());
    }

    /**
     * BoardCategory Setting
     * @param board
     */
    public void BoardCategorySetting(Board board) {
        if (board.getBoard_category() == 0 ){
            board.setBoard_category(1);
        }
    }

    /**
     * BoardNumber Setting
     * @param boardNo
     * @return
     */
    public Board boardNoSetting(Long boardNo) {
        Board board = new Board();
        board.setBoard_no(boardNo);
        return board;
    }

    /**
     * BoardList Paging Setting
     * @param pageable
     * @return
     */
    public Pageable getPageableBoard(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "boardNo"));
        return pageable;
    }

}
