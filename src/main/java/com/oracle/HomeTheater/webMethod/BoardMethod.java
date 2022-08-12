package com.oracle.HomeTheater.webMethod;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class BoardMethod {
    private final MemberRepository memberRepository;

    public void boardNullCheck(Board board) {
        try{
            if(board == null) {
                throw new NullPointerException("board == null");
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void BoardMemberSetting(String loginMember, BoardJpa boardJpa) {
        Optional<MemberJpa> memberJpa = memberRepository.findById(loginMember);
        boardJpa.addMember(memberJpa.get());
    }

}
