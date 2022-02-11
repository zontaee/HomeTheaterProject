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



}
