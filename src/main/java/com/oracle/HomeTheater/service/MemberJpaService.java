package com.oracle.HomeTheater.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.HomeTheater.dao.MemberJpaRepository;
import com.oracle.HomeTheater.domain.MemberJpa;

@Transactional
@Service
public class MemberJpaService {
	private final MemberJpaRepository memberJpaRepository;
    
	public MemberJpaService(MemberJpaRepository memberJpaRepository) {
		this.memberJpaRepository = memberJpaRepository;
	}

	// 회원가입
	public void joinUser(MemberJpa member) {
		System.out.println("CH_MemberJpaRepository joinUser Start...");
		memberJpaRepository.save(member);
	}

	// 로그인
	public MemberJpa loginUser(String m_id, String m_password) {
		System.out.println("CH_MemberJpaRepository loginUser Start...");
		MemberJpa memberVO = memberJpaRepository.selectUserInfo(m_id,m_password);
		return memberVO;
	}



	
	

	
}