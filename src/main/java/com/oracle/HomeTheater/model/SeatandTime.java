package com.oracle.HomeTheater.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SeatandTime {
    private String se_number;
    private String se_time;
    private String se_date ;
    private int mo_number;
    private String se_identify;

    @Override
    public String toString() {
        return "SeatandTime{" +
                "se_number='" + se_number + '\'' +
                ", se_time='" + se_time + '\'' +
                ", se_date='" + se_date + '\'' +
                ", mo_number=" + mo_number +
                ", se_identify='" + se_identify + '\'' +
                '}';
    }
}
