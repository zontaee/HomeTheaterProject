package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class MemberJpaRepositoryTest {
    @PersistenceContext
    EntityManager em;
    @Test
    void jpaTest() {
        MemberJpa memberJpa = new MemberJpa("id","123","조인태","010-2233-2525","집","123");

        em.persist(memberJpa);

        em.flush();
        em.clear();
        QMember qmemberJpa = new QMember("qmember"); // variable -> 별칭
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        MemberJpa member = queryFactory
                .selectFrom(qmemberJpa)
                .fetchOne();

        assertThat(member.getMemberId()).isEqualTo("id");

    }

    @Test
    void selectUserInfo() {
    }
}