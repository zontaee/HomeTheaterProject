package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

    public SeatandTime(String se_number, String se_time, String se_date, int mo_number, String se_identify) {
        this.se_number = se_number;
        this.se_time = se_time;
        this.se_date = se_date;
        this.mo_number = mo_number;
        this.se_identify = se_identify;
    }

    public SeatandTime(String se_number, String se_time, String se_date, int mo_number, String se_identify, String m_id) {
        this.se_number = se_number;
        this.se_time = se_time;
        this.se_date = se_date;
        this.mo_number = mo_number;
        this.se_identify = se_identify;
        this.m_id = m_id;
    }
}
