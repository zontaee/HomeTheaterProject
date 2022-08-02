package com.oracle.HomeTheater.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@IdClass(MemberJpaId.class)
@Table(name = "Member")
@NoArgsConstructor
public class MemberJpa{
	@Id
	private String m_id;
	private String m_password;
	private String m_name;
	@Id
	private String m_phonenumber;
	private String m_address;
	private String m_email;

	public MemberJpa(String m_id, String m_password, String m_name, String m_phonenumber, String m_address, String m_email) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_phonenumber = m_phonenumber;
		this.m_address = m_address;
		this.m_email = m_email;
	}
}
