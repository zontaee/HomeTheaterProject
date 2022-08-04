package com.oracle.HomeTheater.service;

import com.oracle.HomeTheater.domain.MemberJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.HomeTheater.repository.MemberRepository;
@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class MemberJpaService {
    private final MemberRepository memberRepository;


    // 회원가입
    public void joinUser(MemberJpa memberJpa) {
        System.out.println("CH_MemberJpaRepository joinUser Start...");
        memberRepository.save(memberJpa);
    }

    // 로그인
/*	public Member loginUser(String m_id, String m_password) {
        log.info("memberid = "+ m_id);
        log.info("memberPassword= "+ m_password);
		System.out.println("CH_MemberJpaRepository loginUser Start...");
		Member memberVO = memberJpaRepository.selectUserInfo(m_id,m_password);
		return memberVO;
	}*/
    public MemberJpa loginUser(String m_id, String m_password) {
        System.out.println("MemberJpaRepository loginUser Start...");
        log.info("memberid = "+ m_id);
        log.info("memberPassword= "+ m_password);
        MemberJpa memberJpaVO = memberRepository.selectUserInfo(m_id, m_password);
        log.info(memberJpaVO.toString());
        return memberJpaVO;
    }


}