package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Reservation {
    private int re_number;
    private String se_time;
    private String se_date ;
    private String se_number;
    private String se_identify;
    private String pay_how;
    private String pay_totalprice;
    private String re_date;
    private String m_id;
    private int mo_number;


    private String m_point; //저장용

    @Override
    public String toString() {
        return "Reservation{" +
                "re_number=" + re_number +
                ", se_time='" + se_time + '\'' +
                ", se_date='" + se_date + '\'' +
                ", se_number='" + se_number + '\'' +
                ", se_identify='" + se_identify + '\'' +
                ", pay_how='" + pay_how + '\'' +
                ", pay_totalprice='" + pay_totalprice + '\'' +
                ", re_date='" + re_date + '\'' +
                ", m_id='" + m_id + '\'' +
                ", mo_number=" + mo_number +
                ", m_point='" + m_point + '\'' +
                '}';
    }
}
