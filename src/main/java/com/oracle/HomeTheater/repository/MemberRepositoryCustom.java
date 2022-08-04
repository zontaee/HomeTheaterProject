package com.oracle.HomeTheater.repository;

import com.oracle.HomeTheater.domain.MemberJpa;

import java.util.List;

public interface MemberRepositoryCustom {
    MemberJpa selectUserInfo(String m_id, String m_password);

    List<MemberJpa> insertMember(MemberJpa memberJpa);
}
