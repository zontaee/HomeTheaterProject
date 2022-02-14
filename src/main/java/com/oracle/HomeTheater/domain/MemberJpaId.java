package com.oracle.HomeTheater.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberJpaId implements Serializable{
	// 복합키 설정을 위한 class
	private String m_id;
	private String m_phonenumber;
}
