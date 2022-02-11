package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private String m_id;
    private String password;
    private String m_name;
    private String m_phonenumber;
    private String m_address;
    private String m_email;
    private String m_point;
    private String m_delchk;


}
