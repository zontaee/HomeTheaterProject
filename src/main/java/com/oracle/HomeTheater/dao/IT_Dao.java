package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.SeatandTime;

import java.util.List;

public interface IT_Dao {

    Movie findMovie(int mo_number);

    List<SeatandTime> findDate(int mo_number);

    List<SeatandTime> findTime(int mo_number);

    List<SeatandTime> findSeatData(SeatandTime seatandTime);

    int reservationSave(SeatandTime seatandTime);

    Member memberInfo(String m_id);

    int SeatandTimeUpdate(SeatandTime seatandTime);

    int memberPointUpdate(SeatandTime seatandTime);


    int deleteReservation(String re_number);

    List<SeatandTime> serchTime(SeatandTime seatandTime);

}
