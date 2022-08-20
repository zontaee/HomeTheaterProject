package com.oracle.HomeTheater.webMethod;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DTOConverter {


    public BoardJpa convertorDtoToEntityBoard(Board board) {
        MemberJpa memberJpa = new MemberJpa();//<-member 쿼리를 날려줘야하나?
        memberJpa.setMemberId(board.getM_id());
        BoardJpa boardJpa = new BoardJpa(board.getBoard_no(),board.getBoard_category(),board.getBoard_title(),
                board.getBoard_content(),board.getBoard_date(),board.getBoard_hit(),memberJpa);
        return boardJpa;
    }

    public Board convertorEntityToDtoBoard(BoardJpa boardJpa) {
        Board board = new Board(boardJpa.getBoardNo(), boardJpa.getBoardCategory(), boardJpa.getBoardTitle(),
                boardJpa.getBoardContent(), boardJpa.getBoardDate(), boardJpa.getBoardHit(),boardJpa.getMemberJpa().getMemberId());
        return board;
    }

    public Page<Board> pageBoardJpaListToPageBoardList(Page<BoardJpa> boardJpaList) {
        Page<Board> BoardList = boardJpaList.map(m -> new Board(m.getBoardNo(),m.getBoardCategory(),m.getBoardTitle(),m.getBoardContent(),
                m.getBoardDate(),m.getBoardHit(),m.getMemberJpa().getMemberId()));
        return BoardList;
    }
    public Member convertorMemberJpaToMember(MemberJpa memberJpa){
        Member member = new Member(memberJpa.getMemberId(), memberJpa.getMemberPassword(), memberJpa.getMemberName(), memberJpa.getMemberPhonenumber(),
                memberJpa.getMemberAddress(), memberJpa.getMemberEmail(), memberJpa.getMemberPoint(), memberJpa.getMemberDelchk());
        return member;
    }
}