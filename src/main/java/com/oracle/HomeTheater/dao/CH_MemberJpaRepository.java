package com.oracle.HomeTheater.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oracle.HomeTheater.domain.MemberJpa;

@Repository
public interface CH_MemberJpaRepository extends JpaRepository<MemberJpa, String>{

	@Query("select u from MemberJpa u where u.m_id=:m_id and u.m_password=:m_password")
	MemberJpa selectUserInfo(@Param("m_id")String m_id,@Param("m_password")String m_password);


}