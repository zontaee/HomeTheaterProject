package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.domain.QMemberJpa;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
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
        QMemberJpa qmemberJpa = new QMemberJpa("qmemberJpa"); // variable -> 별칭
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        MemberJpa member = queryFactory
                .selectFrom(qmemberJpa)
                .fetchOne();

        assertThat(member.getM_id()).isEqualTo("id");

    }

    @Test
    void selectUserInfo() {
    }
}