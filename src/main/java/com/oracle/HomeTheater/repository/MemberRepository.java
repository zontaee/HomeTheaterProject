package com.oracle.HomeTheater.repository;

import com.oracle.HomeTheater.domain.MemberJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberJpa, String> ,MemberRepositoryCustom {

	/*@Query("select u from MemberJpa u where u.memberId=:m_id and u.memberPassword=:m_password")
    MemberJpa selectUserInfo(@Param("m_id")String m_id, @Param("m_password")String m_password);
*/

}