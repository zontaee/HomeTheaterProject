package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String m_id;
    private String password;
    private String m_name;
    private String m_phonenumber;
    private String m_address;
    private String m_email;
    private String m_point;
    private String m_delchk;

    @Override
    public String toString() {
        return "Member{" +
                "m_id='" + m_id + '\'' +
                ", password='" + password + '\'' +
                ", m_name='" + m_name + '\'' +
                ", m_phonenumber='" + m_phonenumber + '\'' +
                ", m_address='" + m_address + '\'' +
                ", m_email='" + m_email + '\'' +
                ", m_point='" + m_point + '\'' +
                ", m_delchk='" + m_delchk + '\'' +
                '}';
    }
}
