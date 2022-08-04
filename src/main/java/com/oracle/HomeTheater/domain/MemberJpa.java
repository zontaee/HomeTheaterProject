package com.oracle.HomeTheater.domain;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Member")
@NoArgsConstructor
public class MemberJpa {
	@Id
	@Column(name = "M_Id")
	private String memberId;
	@Column(name = "M_Password")
	private String memberPassword;
	@Column(name = "M_Name")
	private String memberName;
	@Column(name = "M_Phonenumber")
	private String memberPhonenumber;
	@Column(name = "M_Address")
	private String memberAddress;
	@Column(name = "M_Email")
	private String memberEmail;
	@Column(name = "M_Point")
	private String memberPoint;
	@Column(name = "M_Delchk")
	private String memberDelchk;

	@OneToMany(mappedBy = "memberJpa",cascade = CascadeType.REMOVE,orphanRemoval = true )
	List<BoardJpa> bbs = new ArrayList<>();


	public MemberJpa(String memberId, String memberPassword, String memberName, String memberPhonenumber, String memberAddress, String memberEmail) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhonenumber = memberPhonenumber;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
	}


}
