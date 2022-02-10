package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatandTime {
    private String se_number;
    private String se_time;
    private String se_date;
    private int mo_number;
    private String se_identify;
    // dto 저장용용
    private String m_id;
    private String pay_how;
    private String pay_totalprice;
    private String m_point;
    private String re_number;


    @Override
    public String toString() {
        return "SeatandTime{" +
                "se_number='" + se_number + '\'' +
                ", se_time='" + se_time + '\'' +
                ", se_date='" + se_date + '\'' +
                ", mo_number=" + mo_number +
                ", se_identify='" + se_identify + '\'' +
                ", m_id='" + m_id + '\'' +
                ", pay_how='" + pay_how + '\'' +
                ", pay_totalprice='" + pay_totalprice + '\'' +
                ", m_point='" + m_point + '\'' +
                '}';
    }
}
