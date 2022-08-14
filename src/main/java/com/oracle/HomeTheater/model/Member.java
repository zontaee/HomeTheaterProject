package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
    private String m_id;
    private String m_password;
    private String m_name;
    private String m_phonenumber;
    private String m_address;
    private String m_email;
    private String m_point;
    private String m_delchk;

    public Member() {
    }

    public Member(String m_id, String m_password, String m_name, String m_phonenumber, String m_address, String m_email, String m_point, String m_delchk) {
        this.m_id = m_id;
        this.m_password = m_password;
        this.m_name = m_name;
        this.m_phonenumber = m_phonenumber;
        this.m_address = m_address;
        this.m_email = m_email;
        this.m_point = m_point;
        this.m_delchk = m_delchk;
    }
}
