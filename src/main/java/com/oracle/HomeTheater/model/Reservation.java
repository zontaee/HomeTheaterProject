package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Reservation {
    private int re_number;
    private String se_time;
    private String se_date;
    private String se_number;
    private String se_identify;
    private String pay_how;
    private String pay_totalprice;
    private String re_date;
    private String m_id;
    private int mo_number;


    private String m_point; //저장용


}
