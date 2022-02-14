package com.oracle.HomeTheater.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@IdClass(MemberJpaId.class)
@Table(name = "Member")
public class MemberJpa{
	@Id
	private String m_id;
	private String m_password;
	private String m_name;
	@Id
	private String m_phonenumber;
	private String m_address;
	private String m_email;
	
	
	

	
}
