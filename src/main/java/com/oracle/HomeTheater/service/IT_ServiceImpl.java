package com.oracle.HomeTheater.service;

import com.oracle.HomeTheater.dao.IT_Dao;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.SeatandTime;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IT_ServiceImpl implements IT_Service {

    private final IT_Dao ITDao;


    @Override
    public Movie findMovie(int mo_number) {

        log.info("resvervation(service) findMovie start mo_number -> " + mo_number);
        Movie findMovie = ITDao.findMovie(mo_number);
        return findMovie;
    }

    @Override
    public List<SeatandTime> findDate(int mo_number) {
        log.info("resvervation(service) findDate start mo_number -> " + mo_number);
        List<SeatandTime> findDate = ITDao.findDate(mo_number);
        return findDate;
    }

    @Override
    public List<SeatandTime> findTime(int mo_number) {
        log.info("resvervation(service) findTime start mo_number -> " + mo_number);
        List<SeatandTime> findTime = ITDao.findTime(mo_number);
        return findTime;
    }

    @Override
    public List<SeatandTime> findSeatData(SeatandTime seatandTime) {
        log.info("reservationtimedata(Service) findseat start");
        List<SeatandTime> seatInfo = ITDao.findSeatData(seatandTime);
        return seatInfo;
    }

    @Override
    public int reservationSave(SeatandTime seatandTime) {
        log.info("reservationSave(service) start");
        int result = ITDao.reservationSave(seatandTime);
        return result;
    }

    @Override
    public Member memberInfo(String m_id) {
        log.info("memberInfo(service) start");
        Member memberInfo = ITDao.memberInfo(m_id);
        return memberInfo;
    }

    @Override
    public int SeatandTimeUpdate(SeatandTime seatandTime) {
        log.info("SeatandTimeUpdate(service) start");
        int resultUpdate = ITDao.SeatandTimeUpdate(seatandTime);
        return resultUpdate;
    }

    @Override
    public int memberPointUpdate(SeatandTime seatandTime) {
        log.info("memberPointUpdate(service) start");
        int resultUpdate = ITDao.memberPointUpdate(seatandTime);
        return resultUpdate;
    }

    @Override
    public int deleteReservation(String re_number) {
        log.info("deleteReservation(service) start");
        int deleteReservation = ITDao.deleteReservation(re_number);
        return deleteReservation;
    }

    @Override
    public List<SeatandTime> serchTime(SeatandTime seatandTime) {
        log.info("serchTime(service) start");
        List<SeatandTime> findtime = ITDao.serchTime(seatandTime);
            return findtime;

    }


}
