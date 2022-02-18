package com.oracle.HomeTheater.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.HomeTheater.dao.CH_MemberJpaRepository;
import com.oracle.HomeTheater.domain.MemberJpa;

@Transactional
@Service
public class CH_MemberJpaService {
	private final CH_MemberJpaRepository memberJpaRepository;

	public CH_MemberJpaService(CH_MemberJpaRepository memberJpaRepository) {
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