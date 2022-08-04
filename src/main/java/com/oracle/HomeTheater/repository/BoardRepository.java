package com.oracle.HomeTheater.repository;

import com.oracle.HomeTheater.domain.BoardJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardJpa,Long>,BoardRepositoryCustom{

}
