package com.oracle.HomeTheater.repository;

import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    @PersistenceContext
    EntityManager em;
    QMember member = QMember.member;
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @Override
    public MemberJpa selectUserInfo(String m_id, String m_password) {

        MemberJpa findmember = queryFactory.
                 select(member).from(member)
                .where(member.memberId.eq(m_id).and(member.memberPassword.eq(m_password)))
                .fetchOne();
        return findmember;
    }

    @Override
    public List<MemberJpa> insertMember(MemberJpa memberJpa) {
        List<MemberJpa> fetch = queryFactory.selectFrom(this.member).fetch();
        return fetch;
    }
}
